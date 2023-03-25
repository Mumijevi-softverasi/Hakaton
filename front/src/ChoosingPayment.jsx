import React, { useState, useEffect } from "react";
import "./ChoosingPayment.css";

<style>
    @import url('https://fonts.googleapis.com/css2?family=Roboto:ital,wght@1,300&display=swap');
</style>


export default function ChoosingPayment() {
    const [selectedOption, setSelectedOption] = useState("");
    const [isSelected, setIsSelected] = useState(false);
    const [paymentInfo, setPaymentInfo] = useState(null);

    useEffect(() => {
        fetch('http://10.99.189.54:9000/paymentInfo')
            .then(response => response.json())
            .then(data => setPaymentInfo(data))
            .catch(error => console.error(error));
    }, []);

    const options = paymentInfo?.map(info => info.name) || [];

    const handleChange = (event) => {
        setSelectedOption(event.target.value);
    };

    const handleButtonClick = () => {
        setIsSelected(true);
    };

    if (!paymentInfo) {
        return <div>Loading payment info...</div>;
    }

    return (
        <div className="dropdown-container">
            <div className="select-container">
                <select value={selectedOption} onChange={handleChange}>
                    <option value="">Izaberi opciju za plaćanje</option>
                    {options.map((option, index) => (
                        <option key={index} value={option}>
                            {option}
                        </option>
                    ))}
                </select>
            </div>
            <div className="button-container">
                <button className="confirmation-button" onClick={handleButtonClick}>
                    Potvrdi
                </button>
            </div>
        </div>
    );
}  