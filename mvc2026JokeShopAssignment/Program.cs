using Microsoft.EntityFrameworkCore;
using mvc2026JokeShopAssignment.Data;

namespace mvc2026JokeShopAssignment
{
    public class Program
    {
        public static void Main(string[] args)
        {
            var builder = WebApplication.CreateBuilder(args);

            // Add services to the container.
            builder.Services.AddControllersWithViews();

            var connectionString = builder.Configuration.GetConnectionString("JokeShopConnection") ?? throw new InvalidOperationException("Connection string 'JokeShopConnection' not found.");
            builder.Services.AddDbContext<JokeShopContext>(options =>
                options.UseSqlServer(connectionString));

            var app = builder.Build();

            // Configure the HTTP request pipeline.
            if (!app.Environment.IsDevelopment())
            {
                app.UseExceptionHandler("/Home/Error");
            }
            app.UseRouting();

            app.UseAuthorization();

            app.MapStaticAssets();
            app.MapControllerRoute(
                name: "default",
                pattern: "{controller=Jokes}/{action=Index}/{id?}")
                .WithStaticAssets();

            app.Run();
        }
    }
}
