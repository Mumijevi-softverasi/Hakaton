import React from 'react';
import './LoginForm.css';
<style>
    @import url('https://fonts.googleapis.com/css2?family=Dosis:wght@300;400&family=Roboto:ital,wght@1,300&display=swap');
</style>
function LoginForm() {

    return (

        <form className="login-form">
            <h1>Prijava</h1>
            <div>
                <div className='labels'>
                    <label htmlFor="email">E-mail:</label>
                </div>
                <input className='input' type="email" id="email" name="email" />
                <div className='labels'>
                    <label htmlFor="password">Lozinka:</label>
                </div>
                <input type="password" className='input' />
            </div>
            <button type="submit">Prijavi se</button>
            <div className='newPayment'>
                <a href='#' id='link' >Nisi student-uplati prijavu</a>
            </div>
        </form>
    );
}

export default LoginForm;