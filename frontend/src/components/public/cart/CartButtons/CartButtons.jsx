import PlusIcon from "./svg/plus.svg?react"
import MinusIcon from "./svg/minus.svg?react"
import CrossIcon from "./svg/cross.svg?react"
import "./CartButtons.css"

export function CartButtonPlus({ productId }) {
    return <button className='cart-btn plus' aria-label='Agregar al carrito'><PlusIcon /></button>
}

export function CartButtonMinus({ productId }) {
    return <button className='cart-btn minus' aria-label='Quitar del carrito'><MinusIcon /></button>
}

export function CartButtonRemove({ productId }) {
    return <button className='cart-btn cross' aria-label='Eliminar del carrito'><CrossIcon /></button>
}
