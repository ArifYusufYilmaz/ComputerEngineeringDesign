import React from 'react';
import {createSlice} from '@reduxjs/toolkit';

export const SessionSlice = createSlice({
    name : 'currentUser',
    initialState:{
        value : {
                 loginSituation: false,
                 userId : null,
                 }
    },
    reducers:{
        loginUser : (state, action) =>{
             state.value.loginSituation = true,
             state.value.userId = action.payload
        },
        logoutUser: state=>{
             state.value.loginSituation = false,
             state.value.userId = null
        }
    }
})
export const selectCurrentUser = (state) => state.currentUser.value ;
export const {loginUser, logoutUser} = SessionSlice.actions;
export default SessionSlice.reducer;