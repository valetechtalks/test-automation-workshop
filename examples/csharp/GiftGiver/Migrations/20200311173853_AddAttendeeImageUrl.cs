using System;
using Microsoft.EntityFrameworkCore.Migrations;

namespace GiftGiver.Migrations
{
    public partial class AddAttendeeImageUrl : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AddColumn<string>(
                name: "ImageUrl",
                table: "Attendees",
                nullable: true);
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(name: "ImageUrl", table: "Attendees");
        }
    }
}
