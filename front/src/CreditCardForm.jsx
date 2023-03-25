import { useEffect, useState } from "react";
import './CreditCardForm.css';
import useFetch from "./useFetch";

function CreditCardForm() {
    const [data, setData] = useState('');
    useEffect(() => {
        fetch('http://10.99.189.54:9000/paymentInfo')
            .then(response => response.json())
            .then(data => setData(data))
            .catch(error => console.error(error));
    }, []);

    return (
        <div className="home">

            {data && <p>{data}</p>}
        </div>
    )
}


export default CreditCardForm;