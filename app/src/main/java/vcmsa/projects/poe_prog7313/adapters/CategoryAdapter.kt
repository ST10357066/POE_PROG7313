package vcmsa.projects.poe_prog7313.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import vcmsa.projects.poe_prog7313.R
import vcmsa.projects.poe_prog7313.dataClasses.Category

// Assuming your Category data class looks like this:
// data class Category(val categoryId: Int, val userId: Int, val name: String, val description: String?, val createdAt: LocalDateTime)

class CategoryAdapter(
    private val context: Context,
    private val categories: List<Category>
) : BaseAdapter() {

    override fun getCount(): Int = categories.size

    override fun getItem(position: Int): Any = categories[position]

    override fun getItemId(position: Int): Long = categories[position].categoryId.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Inflate the view if it's not recycled
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_category, parent, false)

        // Get the views from the item layout (adjust IDs accordingly)
        val nameText = view.findViewById<TextView>(R.id.categoryName)
        val descriptionText = view.findViewById<TextView>(R.id.categoryDescription)
        val createdAtText = view.findViewById<TextView>(R.id.categoryCreatedAt)

        // Bind the category data to the views
        val category = categories[position]
        nameText.text = category.name
        descriptionText.text = category.description ?: "No description"
        createdAtText.text = category.createdAt.toString() // Format date as needed

        return view
    }
}
