FROM mcr.microsoft.com/dotnet/sdk:7.0
WORKDIR /app
COPY . /app
RUN dotnet publish -c Release -o out
ENTRYPOINT ["dotnet", "out/payment-service.dll"]
