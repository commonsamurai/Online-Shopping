import React from "react";
import styled from "styled-components";

const Contact = () => {
  const Wrapper = styled.section`
    padding: 9rem 0 5rem 0;
    .container {
      margin-top: 6rem;
      text-align: center;

      .contact-form{
        max-width:50rem;
        margin:auto;
      }
      .contact-inputs{
        
        display: flex;
        flex-direction: column;
        gap: 3rem;

        input[type=submit]{
            cursor:pointer;
            transition: all 0.2s;
            
           
        }

      }
    }
  `;
  return (
    <>
   
    <>
    
<section class="mb-4">

    
    <h2 class="h1-responsive font-weight-bold text-center my-4">Contact us</h2>
    
    <p class="text-center w-responsive mx-auto mb-5">Do you have any questions? Please do not hesitate to contact us directly. Our team will come back to you within
        a matter of hours to help you.</p>
     
       <iframe
        src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3888.003262511136!2d77.5959367!3d12.971642799999996!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3bae16775069abf7%3A0xe138768bb2a0df8a!2sUB%20City!5e0!3m2!1sen!2sin!4v1666854187333!5m2!1sen!2sin"
        width="100%"
        height="450"
        style={{ border: 0 }}
        allowFullScreen=""
        loading="lazy"
        referrerpolicy="no-referrer-when-downgrade"
      ></iframe>
   

        <div class="col-md-3 text-center">
            <ul class="list-unstyled mb-0">
                <li><i class="fas fa-map-marker-alt fa-2x"></i>
                    <p>UB City, Bangalore, Karnataka, India</p>
                </li>

                <li><i class="fas fa-phone mt-4 fa-2x"></i>
                    <p>+91 123 456 789</p>
                </li>

                <li><i class="fas fa-envelope mt-4 fa-2x"></i>
                    <p>contact@onlineshop.com</p>
                </li>
            </ul>
        </div>
           <p class="text-center w-responsive mx-auto mb-0">Send us a mail and we'll reply as soon as possible.</p>
          <Wrapper>
          <div className="container">
        <div className="contact-form">
          <form action="https://formspree.io/f/maykbqaw" method="POST" className="contact-inputs">
            <input
              type="text"
              name="username"
              placeholder="username"
              autoComplete="off"
              required
            />
            <input
              type="email"
              name="Email"
              placeholder="email"
              autoComplete="off"
              required
            />
            <textarea
              name="message"
              cols="30"
              rows="6"
              autoComplete="off"
              required
            ></textarea>
            <input type="submit" value="Send" />
          </form>
        </div>
      </div>
    </Wrapper>


</section>
</>
</>
  );
};

export default Contact;