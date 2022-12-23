import React from "react";
import { configureStore } from "@reduxjs/toolkit";
import currentUserReducer from './SessionSlice';
import { ApiSlice } from "../api/ApiSlice";

export default configureStore({
    reducer:{
        [ApiSlice.reducerPath] : ApiSlice.reducer,
        currentUser : currentUserReducer
    },
    middleware: (getDefaultMiddleware) => getDefaultMiddleware().concat(ApiSlice.middleware),

})