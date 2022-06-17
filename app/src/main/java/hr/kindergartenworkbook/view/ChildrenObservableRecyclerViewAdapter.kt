package hr.kindergartenworkbook.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hr.kindergartenworkbook.R
import hr.kindergartenworkbook.databinding.ChildrenObservableItemBinding
import hr.kindergartenworkbook.model.Child

class ChildrenObservableRecyclerViewAdapter(
    private val children: List<Child>

) :
    RecyclerView.Adapter<ChildrenObservableRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ChildrenObservableItemBinding.bind(itemView)

        fun bind(child: Child) {
            binding.etFullName.text = child.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.children_observable_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(children[position])
    }

    override fun getItemCount(): Int = children.count()
}