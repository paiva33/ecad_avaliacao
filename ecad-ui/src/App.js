import React, { useState } from 'react';
import logo from './logo.svg';
import './App.css';


  // Import components app
import Header from './components/Layout/Header'
import { ArquivoComponent } from './components/arquivo/ArquivoComponent';


class App extends React.Component {

  constructor(props) {
      super(props);      
  }  

  render() {
    return (      
      <div className="App">
          <Header></Header>
          <ArquivoComponent />
      </div>
    );
  }
}

export default App;
