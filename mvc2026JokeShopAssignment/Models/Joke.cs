using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace mvc2026JokeShopAssignment.Models
{
    public class Joke
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int Id { get; set; }

        [Required(ErrorMessage = "The Title field is required.")]
        [StringLength(50, MinimumLength = 3)]
        public string? Title { get; set; }

        [Required(ErrorMessage = "The Joke Text field is required.")]
        [StringLength(350)]
        public string? JokeText { get; set; }

        [Required(ErrorMessage = "The Teaser field is required.")]
        [StringLength(325, MinimumLength = 3)]
        public string? Teaser { get; set; }

        [Required(ErrorMessage = "The Creation Date field is required.")]
        [DataType(DataType.Date)]
        public DateTime? CreationDate { get; set; }
    }
}
