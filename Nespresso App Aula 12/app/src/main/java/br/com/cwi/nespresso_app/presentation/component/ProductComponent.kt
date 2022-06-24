package br.com.cwi.nespresso_app.presentation.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import br.com.cwi.nespresso_app.R
import br.com.cwi.nespresso_app.databinding.ComponentProductBinding

class ProductComponent : ConstraintLayout {

    private lateinit var binding: ComponentProductBinding

    constructor(context: Context): super(context)

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int
    ) : super(context, attrs, defStyleAttr)

    constructor(context: Context, attrs: AttributeSet?): super(context, attrs){
        binding = ComponentProductBinding.inflate(LayoutInflater.from(context), this)

        context.obtainStyledAttributes(
            attrs,
            R.styleable.ProductComponent,
            0,
            0
        ).run {
            binding.tvProductTitle.text = getString(R.styleable.ProductComponent_component_product_title)
            binding.tvProductSubtitle.text = getString(R.styleable.ProductComponent_component_product_subtitle)
            binding.ivProduct.setImageDrawable(getDrawable(R.styleable.ProductComponent_component_product_image))
            setBackgroundColor(
                getColor(R.styleable.ProductComponent_component_product_background_color,
                    ContextCompat.getColor(context, R.color.coffees_color))
            )
            recycle()
        }
    }
}