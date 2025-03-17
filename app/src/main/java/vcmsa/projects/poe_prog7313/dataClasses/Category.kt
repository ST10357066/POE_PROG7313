package vcmsa.projects.poe_prog7313.dataClasses

import java.time.LocalDateTime

data class Category(
    val categoryId: Int,              // Primary Key, auto-increment
    val userId: Int,                  // Foreign Key: References User.userId
    val name: String,                 // Category name (e.g., "Groceries")
    val description: String? = null,  // Optional additional info about the category
    val createdAt: LocalDateTime      // Timestamp when the category was created
)
