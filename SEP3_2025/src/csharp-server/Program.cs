// Minimal ASP.NET Core Server Example
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Http;
using System.Text.Json;

var builder = WebApplication.CreateBuilder(args);
var app = builder.Build();

app.MapGet("/health", () => Results.Ok(new { status = "ok", time = DateTime.UtcNow }));

app.MapGet("/api/items", () =>
{
    var items = new[] {
        new { id = 1, name = "Vinyl-Album-A", available = true },
        new { id = 2, name = "Vinyl-Album-B", available = false }
    };
    return Results.Ok(items);
});

app.MapPost("/api/audit", async (HttpRequest req) =>
{
    using var sr = new StreamReader(req.Body);
    var body = await sr.ReadToEndAsync();
    Console.WriteLine("Received audit: " + body);
    return Results.Created($"/api/audit/1", JsonSerializer.Deserialize<object>(body));
});

app.Run();
