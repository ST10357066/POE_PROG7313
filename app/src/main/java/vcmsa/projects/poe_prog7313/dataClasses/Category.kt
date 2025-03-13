package vcmsa.projects.prog7313_poe.DataClass

data class Category(
    val categoryId: Int,              // Primary Key, auto-increment
    val userId: Int,                  // Foreign Key: References User.userId
    val name: String,                 // Category name (e.g., "Groceries")
    val description: String? = null,  // Optional additional info about the category
    val createdAt: LocalDateTime      // Timestamp when the category was created
)
