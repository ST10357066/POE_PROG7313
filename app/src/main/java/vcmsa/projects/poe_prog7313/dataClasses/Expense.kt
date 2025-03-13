package vcmsa.projects.prog7313_poe.DataClass

data class Expense(
    val expenseId: Int,               // Primary Key, auto-increment
    val userId: Int,                  // Foreign Key: References User.userId
    val categoryId: Int,              // Foreign Key: References Category.categoryId
    val amount: BigDecimal,           // Expense amount
    val expenseDate: LocalDate,       // Date when the expense occurred
    val description: String,          // Description of the expense
    val receiptPhoto: String? = null, // Optional: URL/path to the receipt photo or BLOB representation
    val createdAt: LocalDateTime      // Timestamp when the expense was recorded
)
