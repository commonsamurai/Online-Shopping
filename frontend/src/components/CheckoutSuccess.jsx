import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import styled from "styled-components";
import { clearCart, getTotals } from "../slices/cartSlice";
import axios from "axios";
const querystring = require('querystring')

const CheckoutSuccess = ({orders_n}) => {
  const ORDER_URL = '//localhost:8084/api/v3/addOrders'
  const dispatch = useDispatch();
  const cart = useSelector((state) => state.cart);
  

  useEffect(() => {
    dispatch(clearCart());
  }, [dispatch]);

  useEffect(() => {
    dispatch(getTotals());
    
  }, [cart, dispatch]);

  useEffect( () => {
   
    async function sendData() {
      const order = localStorage.getItem("orders")

      const o  = JSON.parse(order)
      console.log(typeof(order))
      // var json = querystring.parse(order)
      // console.log(json)
      
      
     await axios.post(ORDER_URL, o).then(res => {

          console.log(res.data)
    console.log(order)
          
         })
    
    }
    sendData();
  },[]);

  return (
    <Container>
      <h2>Checkout Successful</h2>
      <p>Your order might take some time to process.</p>
      <p>Check your order status at your profile after about 10mins.</p>
      <p>
        Incase of any inqueries contact the support at{" "}
        <strong>support@onlineshop.com</strong>
      </p>
    </Container>
  );
};

export default CheckoutSuccess;

const Container = styled.div`
  min-height: 80vh;
  max-width: 800px;
  width: 100%;
  margin: auto;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;

  h2 {
    margin-bottom: 0.5rem;
    color: #029e02;
  }
`;
