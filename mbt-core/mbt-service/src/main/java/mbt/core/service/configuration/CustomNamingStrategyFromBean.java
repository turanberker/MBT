package mbt.core.service.configuration;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.expression.BeanFactoryAccessor;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.expression.Expression;
import org.springframework.expression.ParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

@Component
public class CustomNamingStrategyFromBean extends PhysicalNamingStrategyStandardImpl
        implements ApplicationContextAware {

    private final StandardEvaluationContext context = new StandardEvaluationContext();

    private final SpelExpressionParser parser = new SpelExpressionParser();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context.addPropertyAccessor(new BeanFactoryAccessor());
        this.context.setBeanResolver(new BeanFactoryResolver(applicationContext));
        this.context.setRootObject(applicationContext);
    }

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment jdbcEnvironment) {

        if (name != null && name.getText().contains(ParserContext.TEMPLATE_EXPRESSION.getExpressionPrefix())) {
            String nameStr = name.getText();
            // Refer to SimpleElasticSearchPersistenTentent Realism, get the value of the TABLENAME parameters to get the expression
            Expression expression = this.parser.parseExpression(nameStr, ParserContext.TEMPLATE_EXPRESSION);
            return Identifier.toIdentifier((String) expression.getValue(this.context, String.class));
        } else {
            // The default method is unchanged
            return super.toPhysicalTableName(name, jdbcEnvironment);
        }
    }

    @Override
    public Identifier toPhysicalSchemaName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        if (name != null && name.getText().contains(ParserContext.TEMPLATE_EXPRESSION.getExpressionPrefix())) {
            String nameStr = name.getText();
            // Refer to SimpleElasticSearchPersistenTentent Realism, get the value of the SCHEMANAME parameters to get the expression
            Expression expression = this.parser.parseExpression(nameStr, ParserContext.TEMPLATE_EXPRESSION);
            return Identifier.toIdentifier((String) expression.getValue(this.context, String.class));
        } else {
            return super.toPhysicalTableName(name, jdbcEnvironment);
        }

    }
}
