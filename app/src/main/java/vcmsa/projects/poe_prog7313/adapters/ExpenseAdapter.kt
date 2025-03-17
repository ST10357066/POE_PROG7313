package vcmsa.projects.poe_prog7313.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import vcmsa.projects.poe_prog7313.R
import vcmsa.projects.poe_prog7313.dataClasses.Expense

// Assuming your Expense data class looks like this:
// data class Expense(
//    val expenseId: Int,
//    val userId: Int,
//    val categoryId: Int,
//    val amount: BigDecimal,
//    val expenseDate: LocalDate,
//    val description: String,
//    val receiptPhoto: String?,  // URL or path for the photo
//    val createdAt: LocalDateTime
//)

class ExpenseAdapter(
    private val context: Context,
    private val expenses: List<Expense>
) : BaseAdapter() {

    override fun getCount(): Int = expenses.size

    override fun getItem(position: Int): Any = expenses[position]

    override fun getItemId(position: Int): Long = expenses[position].expenseId.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Inflate the view if it's not recycled
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_expense, parent, false)

        // Get the views from the item layout (adjust IDs accordingly)
        val amountText = view.findViewById<TextView>(R.id.expenseAmount)
        val dateText = view.findViewById<TextView>(R.id.expenseDate)
        val descriptionText = view.findViewById<TextView>(R.id.expenseDescription)
        val receiptImage = view.findViewById<ImageView>(R.id.receiptImage)

        // Bind the expense data to the views
        val expense = expenses[position]
        amountText.text = expense.amount.toPlainString()  // Format as needed (e.g., currency format)
        dateText.text = expense.expenseDate.toString()     // Format as needed
        descriptionText.text = expense.description

        // Set image resource if available; otherwise, you might set a placeholder
        // This assumes receiptPhoto is a resource name or you have a way to load the image (e.g., via Glide or Picasso)
        if (expense.receiptPhoto != null) {
            // For demonstration, we assume receiptPhoto holds a drawable resource identifier as String
            val resId = context.resources.getIdentifier(expense.receiptPhoto, "drawable", context.packageName)
            receiptImage.setImageResource(if (resId != 0) resId else R.drawable.placeholder)
        } else {
            receiptImage.setImageResource(R.drawable.placeholder)
        }

        return view
    }
}
