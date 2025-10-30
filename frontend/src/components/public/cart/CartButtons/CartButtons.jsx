import PlusIcon from "./svg/plus.svg?react"
import MinusIcon from "./svg/minus.svg?react"
import CrossIcon from "./svg/cross.svg?react"
import "./CartButtons.css"
import { useState } from "react"

export function CartButtonPlus({ productId, onClick }) {
    return <button className='cart-btn plus' onClick={onClick} aria-label='Agregar al carrito'><PlusIcon /></button>
}

export function CartButtonMinus({ productId, onClick }) {
    return <button className='cart-btn minus' onClick={onClick} aria-label='Quitar del carrito'><MinusIcon /></button>
}

export function CartButtonCross({ productId, onClick }) {
    return <button className='cart-btn cross' onClick={onClick} aria-label='Eliminar del carrito'><PlusIcon /></button>
}

export function CartButtonDummy({ productId }) {
    let [positive, setPositive] = useState(true);
    if (positive) {
        return <CartButtonPlus onClick={() => setPositive(false)} />
    } else {
        return <CartButtonCross onClick={() => setPositive(true)} />
    }
}
