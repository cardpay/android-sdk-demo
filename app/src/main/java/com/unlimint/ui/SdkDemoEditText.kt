package com.unlimint.ui

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.text.InputFilter
import android.text.InputType
import android.text.TextWatcher
import android.text.method.DigitsKeyListener
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.*
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.transition.TransitionManager
import com.unlimint.R

open class SdkDemoEditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defAttrRes: Int = 0
) : FrameLayout(context, attrs, defAttrRes) {

    private val label: TextView
    val input: EditText
    private val error: TextView
    private val inputContainer: FrameLayout
    protected var endImageView: ImageView? = null

    var isDisable: Boolean = false
        private set

    var hasFocus: Boolean = false
        private set

    var errorText: String = ""
        private set

    protected var textType: Int = -1

    private val disabledBackground: Drawable?
    private val errorBackground: Drawable?
    private val defaultBackground: Drawable?

    init {
        LayoutInflater.from(context).inflate(R.layout.view_input, this)
        label = findViewById(R.id.input_label)
        input = findViewById(R.id.input)
        error = findViewById(R.id.input_error)
        inputContainer = findViewById(R.id.input_container)
        endImageView = findViewById(R.id.endIcon)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.SdkDemoEditText, 0, 0)
        // Setup Text
        label.text = typedArray.getText(R.styleable.SdkDemoEditText_labelText) ?: "Label"
        input.hint = typedArray.getText(R.styleable.SdkDemoEditText_hintText) ?: "Hint"
        input.setText(typedArray.getText(R.styleable.SdkDemoEditText_inputText) ?: "")

        // Setup text color
        label.setTextColor(
            typedArray,
            R.styleable.SdkDemoEditText_labelTextColor,
            defStateListRes = R.drawable.edit_text_label_selector
        )

        input.setTextColor(
            typedArray,
            R.styleable.SdkDemoEditText_inputTextColor,
            defColorRes = R.color.unlimint_color_text_primary
        )
        input.setHintColor(
            typedArray,
            R.styleable.SdkDemoEditText_inputHintTextColor,
            defColor = R.color.unlimint_color_field_placeholder
        )
        error.setTextColor(
            typedArray,
            R.styleable.SdkDemoEditText_errorTextColor,
            defColorRes = R.color.unlimint_color_field_error_border
        )

        // Setup background
        defaultBackground = typedArray.getBackground(
            R.styleable.SdkDemoEditText_defaultInputBackground,
            R.drawable.edit_text_background
        )
        disabledBackground = typedArray.getBackground(
            R.styleable.SdkDemoEditText_disableInputBackground,
            R.drawable.edit_text_background_disable
        )
        errorBackground = typedArray.getBackground(
            R.styleable.SdkDemoEditText_errorInputBackground,
            R.drawable.edit_text_background_error
        )

        // Setup text size
        label.setTextSize(
            typedArray,
            R.styleable.SdkDemoEditText_labelTextSize,
            R.dimen.unlimint_subhead_14
        )
        input.setTextSize(
            typedArray,
            R.styleable.SdkDemoEditText_inputTextSize,
            R.dimen.unlimint_headline_16
        )
        error.setTextSize(
            typedArray,
            R.styleable.SdkDemoEditText_errorTextSize,
            R.dimen.unlimint_caption_11
        )

        // Setup text type
        val isNumberType = typedArray.getBoolean(R.styleable.SdkDemoEditText_isNumberType, false)
        val isPhoneType = typedArray.getBoolean(R.styleable.SdkDemoEditText_isPhoneType, false)
        val isTextType = typedArray.getBoolean(R.styleable.SdkDemoEditText_isTextType, false)
        val isDateTime = typedArray.getBoolean(R.styleable.SdkDemoEditText_isDateTimeType, false)
        val isTextMultilineType =
            typedArray.getBoolean(R.styleable.SdkDemoEditText_isTextMultilineType, false)
        textType = when {
            isNumberType -> InputType.TYPE_CLASS_NUMBER
            isPhoneType -> InputType.TYPE_CLASS_PHONE
            isDateTime -> InputType.TYPE_CLASS_DATETIME
            isTextType -> InputType.TYPE_CLASS_TEXT
            isTextMultilineType -> InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_MULTI_LINE
            else -> InputType.TYPE_CLASS_TEXT// add another types later
        }

        typedArray.getString(R.styleable.SdkDemoEditText_digits)?.let { inputDigits ->
            input.keyListener = DigitsKeyListener.getInstance(inputDigits)
        }

        val textLength = typedArray.getInt(R.styleable.SdkDemoEditText_maxLength, -1)
        if (textLength != -1) {
            input.filters = arrayOf(InputFilter.LengthFilter(textLength))
        }

        val ime = typedArray.getInt(R.styleable.SdkDemoEditText_demoImeOptions, EditorInfo.IME_NULL)
        input.imeOptions = ime

        // Setup Font
        input.typeface = typedArray.getTextFont(R.styleable.SdkDemoEditText_inputTextFont)
        label.typeface = typedArray.getTextFont(R.styleable.SdkDemoEditText_labelTextFont)
        error.typeface = typedArray.getTextFont(R.styleable.SdkDemoEditText_errorTextFont)

        typedArray.recycle()

        setupView()
    }

    private fun setupView() {
        disable(false)
        addFocusListener { _, hasFocus ->
            input.isSelected = hasFocus
        }
    }

    fun disable(isDisable: Boolean) {
        this.isDisable = isDisable
        label.isSelected = !isDisable
        input.isFocusable = !isDisable
        input.isFocusableInTouchMode = !isDisable

        removeError()
        if (isDisable) {
            setEditTextBackground(disabledBackground)
            inputContainer.foreground = disabledBackground
            setError("", false)
        } else {
            setEditTextBackground(defaultBackground)
            inputContainer.foreground = null
        }
    }

    fun setError(message: String, withAnimation: Boolean = true) {
        if (isDisable) return

        errorText = message

        setEditTextBackground(errorBackground)
        if (error.text.toString() != message || error.visibility != View.VISIBLE) {
            if (withAnimation) {
                TransitionManager.beginDelayedTransition(this)
            }
            error.text = message
            error.visibility = View.VISIBLE
        }
    }

    fun removeError(withAnimation: Boolean = true) {
        if (isDisable) return

        errorText = ""
        setEditTextBackground(defaultBackground)
        if (error.visibility != View.GONE) {
            if (withAnimation) {
                TransitionManager.beginDelayedTransition(this)
            }
            error.visibility = View.GONE
        }
    }

    fun setFocus(hasFocus: Boolean) {
        if (isDisable) return
        this.hasFocus = hasFocus

        input.isSelected = hasFocus
        if (hasFocus) {
            input.requestFocus()
        } else {
            input.clearFocus()
        }
    }

    fun addTextWatcher(textWatcher: TextWatcher) {
        input.addTextChangedListener(textWatcher)
    }

    fun removeTextWatcher(textWatcher: TextWatcher) {
        input.removeTextChangedListener(textWatcher)
    }

    fun addFocusListener(listener: OnFocusChangeListener?) {
        input.onFocusChangeListener = listener
    }

    private fun setEditTextBackground(drawable: Drawable?) {
        if (input.background != drawable) {
            input.background = drawable
        }
    }

    private fun TextView.setTextColor(
        ta: TypedArray,
        @StyleableRes res: Int,
        @ColorRes defColorRes: Int? = null,
        @DrawableRes defStateListRes: Int? = null,
    ) {
        val defStateList = defStateListRes?.let { ContextCompat.getColorStateList(context, it) }
        val colorStateList = ta.getColorStateList(res)

        val defColor = defColorRes?.let { ContextCompat.getColor(context, it) }
        val textColor = ta.getColor(res, -1)

        when {
            colorStateList != null -> setTextColor(colorStateList)
            textColor != -1 -> setTextColor(textColor)
            defColor != null -> setTextColor(defColor)
            defStateList != null -> setTextColor(defStateList)
        }
    }

    private fun TextView.setHintColor(
        ta: TypedArray,
        @StyleableRes res: Int,
        @ColorRes defColor: Int
    ) {
        val colorStateList = ta.getColorStateList(res)
        val textColor = ta.getColor(res, ContextCompat.getColor(context, defColor))
        if (colorStateList != null) {
            setHintTextColor(colorStateList)
        } else {
            setHintTextColor(textColor)
        }
    }

    private fun TextView.setTextSize(
        ta: TypedArray,
        @StyleableRes index: Int,
        @DimenRes defSize: Int
    ) {
        val textSize =
            ta.getDimensionPixelSize(index, resources.getDimensionPixelSize(defSize)).toFloat()
        setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize)
    }

    private fun TypedArray.getBackground(
        @StyleableRes index: Int,
        @DrawableRes defBackground: Int
    ) = getDrawable(index) ?: ContextCompat.getDrawable(context, defBackground)

    private fun TypedArray.getIcon(@StyleableRes index: Int) = getDrawable(index)

    private fun TypedArray.getTextFont(@StyleableRes index: Int) =
        if (isInEditMode) {
            Typeface.DEFAULT
        } else {
            ResourcesCompat.getFont(context, getResourceId(index, R.font.inter_400_regular))
        }
}