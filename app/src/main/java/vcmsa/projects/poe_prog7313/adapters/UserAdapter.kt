package vcmsa.projects.poe_prog7313.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import vcmsa.projects.poe_prog7313.R
import vcmsa.projects.poe_prog7313.dataClasses.User

// Assuming your User data class looks like this:
// data class User(val userId: Int, val username: String, val passwordHash: String, val email: String?, val createdAt: LocalDateTime)

class UserAdapter(
    private val context: Context,
    private val users: List<User>
) : BaseAdapter() {

    override fun getCount(): Int = users.size

    override fun getItem(position: Int): Any = users[position]

    override fun getItemId(position: Int): Long = users[position].userId.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Inflate the view if it's not recycled
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)

        // Get the views from the item layout (adjust IDs accordingly)
        val usernameText = view.findViewById<TextView>(R.id.usernameText)
        val emailText = view.findViewById<TextView>(R.id.emailText)
        val createdAtText = view.findViewById<TextView>(R.id.createdAtText)

        // Bind the user data to the views
        val user = users[position]
        usernameText.text = user.username
        emailText.text = user.email ?: "No email"
        createdAtText.text = user.createdAt.toString()  // Format date as needed

        return view
    }
}
