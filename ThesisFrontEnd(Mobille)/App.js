import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';
import ApiExample from './components/ApiExample';


import { ApiProvider } from '@reduxjs/toolkit/dist/query/react';
import { ApiSlice } from './api/ApiSlice';

import store from './globalStates/store';
import { Provider } from 'react-redux';
import Router from './routers/Router';
import Toast from 'react-native-toast-message';



export default function App() {

  return (
    
      <Provider store={store}>
        <View style  = {styles.container}>
          <Router></Router>
        </View>
        <Toast/>
      </Provider>
  );
}   

const styles = StyleSheet.create({
   container: {
     flex: 1,
  //   backgroundColor: '#fff',
  //   alignItems: 'center',
  //   justifyContent: 'center',
   },
});
