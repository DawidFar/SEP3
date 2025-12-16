using System;
using System.Text;
using RabbitMQ.Client;
using RabbitMQ.Client.Events;

var factory = new ConnectionFactory(){ HostName = Environment.GetEnvironmentVariable("RABBITMQ_HOST") ?? "localhost" };
using var connection = factory.CreateConnection();
using var channel = connection.CreateModel();

channel.ExchangeDeclare(exchange: "orders.exchange", type: "direct", durable: true);
channel.QueueDeclare(queue: "orders.created.queue", durable: true, exclusive: false, autoDelete: false);
channel.QueueBind("orders.created.queue", "orders.exchange", "orders.created");

var consumer = new EventingBasicConsumer(channel);
consumer.Received += (model, ea) => {
    var body = ea.Body.ToArray();
    var message = Encoding.UTF8.GetString(body);
    Console.WriteLine($"[PaymentService] Received OrderCreated: {message}");
    // Simulate success
    Console.WriteLine($"[PaymentService] Simulating payment for order {message} -> SUCCEEDED");
    // TODO: publish PaymentSucceeded event / call Order Service in a full implementation
};

channel.BasicConsume(queue: "orders.created.queue", autoAck: true, consumer: consumer);

Console.WriteLine("Payment service listening. Press [enter] to exit.");
Console.ReadLine();
