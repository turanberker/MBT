package mbt.kafka.consumer;

public interface IConsumer<T> {

    void consumeMessage(T message);
}
