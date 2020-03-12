using System;
using Microsoft.EntityFrameworkCore.Migrations;

namespace GiftGiver.Migrations
{
    public partial class InitialCreate : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "Attendees",
                columns: table => new
                {
                    AttendeeId = table.Column<int>(nullable: false)
                        .Annotation("Sqlite:Autoincrement", true),
                    CreatedDate = table.Column<DateTime>(nullable: false),
                    UpdatedDate = table.Column<DateTime>(nullable: false),
                    VendorUserId = table.Column<int>(nullable: false),
                    RsvpAnswer = table.Column<string>(nullable: true),
                    Name = table.Column<string>(nullable: false),
                    Awarded = table.Column<bool>(nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Attendees", x => x.AttendeeId);
                });

            migrationBuilder.CreateIndex(
                name: "IX_Attendees_VendorUserId",
                table: "Attendees",
                column: "VendorUserId");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Attendees");
        }
    }
}
