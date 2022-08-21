package hr.kindergartenworkbook.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hr.kindergartenworkbook.R
import hr.kindergartenworkbook.databinding.ChildrenObservableItemBinding
import hr.kindergartenworkbook.model.Child

class ChildrenObservableRecyclerViewAdapter(
    private val children: List<Child>,
    private val onNoteCLickEvent: (Child) -> Unit
) :
    RecyclerView.Adapter<ChildrenObservableRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ChildrenObservableItemBinding.bind(itemView)

        fun bind(child: Child, onNoteCLickEvent: (Child) -> Unit) {
            binding.etFullName.text = child.toString()

            binding.btnPositiveGrade.setOnClickListener {
                child.grade = 1
                binding.btnPositiveGrade.setImageResource(R.drawable.plus_fill_icon)
                binding.btnNegativeGrade.setImageResource(R.drawable.minus_icon)
                binding.btnMiddleGrade.setImageResource(R.drawable.plus_minus_icon)
            }
            binding.btnNegativeGrade.setOnClickListener {
                child.grade = 2
                binding.btnNegativeGrade.setImageResource(R.drawable.minus_fill_icon)
                binding.btnPositiveGrade.setImageResource(R.drawable.plus_icon)
                binding.btnMiddleGrade.setImageResource(R.drawable.plus_minus_icon)
            }
            binding.btnMiddleGrade.setOnClickListener {
                child.grade = 3
                binding.btnMiddleGrade.setImageResource(R.drawable.plus_minus_fill_icon)
                binding.btnPositiveGrade.setImageResource(R.drawable.plus_icon)
                binding.btnNegativeGrade.setImageResource(R.drawable.minus_icon)
            }
            binding.btnNote.setOnClickListener {
                onNoteCLickEvent(child)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.children_observable_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(children[position], onNoteCLickEvent)
    }

    override fun getItemCount(): Int = children.count()
}