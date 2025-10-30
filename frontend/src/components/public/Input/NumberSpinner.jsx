import { NeonButton } from "./Buttons";
import "./NumberSpinner.css";

export function NumberSpinner({ value, setValue, min = 1, max = 10 }) {
    const increment = () => setValue((v) => Math.min(max, v + 1));
    const decrement = () => setValue((v) => Math.max(min, v - 1));

    return <div className="num-spinner">
        <NeonButton onClick={decrement}>-</NeonButton>
        <input
            type="number"
            value={value}
            min={min}
            max={max}
            onChange={(e) => setValue(
                Math.min(Math.max(Number(e.target.value), min), max)
            )}
        />
        <NeonButton onClick={increment}>+</NeonButton>
    </div>
}
