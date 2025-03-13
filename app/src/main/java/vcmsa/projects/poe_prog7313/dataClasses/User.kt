package vcmsa.projects.prog7313_poe.DataClass

data class User(
    val userId: Int,                  // Primary Key, auto-increment
    val username: String,             // Unique username
    val passwordHash: String,         // Hashed password
    val email: String? = null,        // Optional email for notifications or recovery
    val createdAt: LocalDateTime      // Timestamp when the account was created
)
