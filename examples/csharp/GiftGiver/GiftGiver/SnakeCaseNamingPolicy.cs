using System.Linq;
using System.Text.Json;

namespace GiftGiver
{
    public class SnakeCaseNamingPolicy : JsonNamingPolicy
    {
        public static SnakeCaseNamingPolicy Instance { get; } = new SnakeCaseNamingPolicy();

        private string ToSnakeCase(string str)
        {
            return string.Concat(str.Select((x, i) => i > 0 && char.IsUpper(x) ? "_" + x.ToString() : x.ToString())).ToLower();
        }

        public override string ConvertName(string name)
        {
            // Conversion to other naming conventaion goes here. Like SnakeCase, KebabCase etc.
            return ToSnakeCase(name);
        }
    }
}