using Microsoft.EntityFrameworkCore;
using mvc2026JokeShopAssignment.Models;

namespace mvc2026JokeShopAssignment.Data
{
    public class JokeShopContext:DbContext
    {
        public DbSet<Joke> JokeList { get; set; }
        public DbSet<Category> Categories { get; set; }
        public JokeShopContext(DbContextOptions<JokeShopContext> options) : base(options) { }
    }
}
