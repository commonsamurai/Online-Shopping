import React, { useEffect, useState } from "react";
import { Navigate } from "react-router-dom";
import { withRouter } from "./with-router";

// const parseJwt = (token) => {
//   try {
//     return JSON.parse(atob(token.split('.')[1]));
//   } catch (e) {
//     return null;
//   }
// };
const AuthVerify = ({children}) => {
  // let location = props.router.location;


    const user = JSON.parse(localStorage.getItem("user"));
    
    if (user) {
      // const decodedJwt = parseJwt(user.accessToken);

      // if (decodedJwt.exp * 1000 < Date.now()) {
      //   localStorage.removeItem("user");
      // }
      return children;
      
    }
      else{
          
          return <Navigate to= '/login' replace/>;
      }

       
    }
  


export default AuthVerify;
