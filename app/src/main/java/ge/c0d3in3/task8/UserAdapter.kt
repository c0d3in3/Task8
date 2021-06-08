package ge.c0d3in3.task8

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ge.c0d3in3.task8.api.dto.User

class UserAdapter(private val onClick: (User) -> Unit): RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private var users: List<User> = listOf()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.user_item_layout,parent,false))

    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users[position]
        val nameTv = holder.itemView.findViewById<TextView>(R.id.nameTv)
        val emailTv = holder.itemView.findViewById<TextView>(R.id.emailTv)

        nameTv.text = "${user.firstName} ${user.lastName}"
        emailTv.text = user.email

        holder.itemView.setOnClickListener {
            onClick.invoke(user)
        }
    }

    fun setUsers(users: List<User>) {
        this.users = users
        notifyDataSetChanged()
    }
}