# Gift giver (C# version)

# Dependencies

- [EntityFrameworkCore 3.1.2](https://www.nuget.org/packages/Microsoft.EntityFrameworkCore/3.1.2)
- [EntityFrameworkCore.Sqlite 3.1.2](https://www.nuget.org/packages/Microsoft.EntityFrameworkCore.Sqlite/3.1.2)

# Get the sources

```shell
git clone --branch ruby-v1.0.1-no-tests https://github.com/valetechtalks/test-automation-workshop.git
cd test-automation-workshop/examples/csharp
```

# Run

You can open the `GiftGiver.sln` and run with [Visual Studio](https://visualstudio.microsoft.com/).

In case you want to run the project by terminal:

```shell
dotnet restore
dotnet run --project ./GiftGiver/GiftGiver.csproj
```

Access http://localhost:5001/attendees

# Deploy

This app is current deployed at [https://gift-giver-in-dotnet.herokuapp.com/](https://gift-giver-in-dotnet.herokuapp.com/).

Routes:

```cmd
curl -XGET https://gift-giver-in-dotnet.herokuapp.com/attendees
curl -XGET https://gift-giver-in-dotnet.herokuapp.com/attendees/awarded
curl -XPOST -d='' https://gift-giver-in-dotnet.herokuapp.com/draw
curl -XPOST -d='' https://gift-giver-in-dotnet.herokuapp.com/refresh
curl -XDELETE https://gift-giver-in-dotnet.herokuapp.com/refresh
```
