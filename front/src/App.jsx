import LoginForm from './LoginForm';
import PaymentDataForm from './PaymentDataForm';
import ChoosingPayment from './ChoosingPayment';
import CreditCardForm from './CreditCardForm';

<style>
  @import url('https://fonts.googleapis.com/css2?family=Roboto:ital,wght@1,300&display=swap');
</style>
function App() {
  return (
    <article className='container'>
      <CreditCardForm />
    </article>
  );
}

export default App;
