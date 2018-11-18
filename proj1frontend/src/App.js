import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

import './include/bootstrap';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import { AppNav } from './Components/AppNav';
import {newReimbursementComponent} from './Components/newReimbursementComponent';
import { homeComponent } from './Components/homeComponent';
import {viewReimbursementComponent} from './Components/viewReimbursementComponent';
import {viewMyReimbursementComponent} from './Components/viewMyReimbursementComponent';
import {SignInComponent} from './Components/SignInComponent';
import { viewReimbursementByIdComponent } from './Components/viewReimbursementByIdComponent';
import { viewReimbursementByStatusComponent } from './Components/viewReimbursementByStatusComponent';
import { viewReimbursementByAuthorComponent } from './Components/viewReimbursementByAuthorComponent';
import { ReimbursementTableComponent } from './Components/ReimbursementTableComponent';
import { resolveReimbursementComponent } from './Components/ResolveReimbursementComponent';
//import { viewReimbursementComponent} from './Components/viewReimbursementComponent';


class App extends Component {


  requireAuth(nextState, replace) {
    // if (!this.state.loggedIn) {
    //   replace({
    //     pathname: '/sign-in'
    //   })
    // }
  }

  render() {
    return (

      
      <BrowserRouter>
        <>
          <AppNav />
          <div id="main_content_containter">
          <Switch>
            <Route path="/home" component={SignInComponent} />
            <Route path="/sign-in" component={SignInComponent} />
            <Route path="/newReimb" component={newReimbursementComponent} onEnter={this.requireAuth} />
            {/* <Route path="/viewReimb" component={viewReimbursementComponent} /> */}
            <Route path="/viewReimb" component={viewReimbursementComponent} onEnter={this.requireAuth} /> {/*This is for testing. Remember to change this back later */}
            <Route path="/myReimb" component={viewMyReimbursementComponent} onEnter={this.requireAuth} /> 
            <Route path="/idReimb" component={viewReimbursementByIdComponent} onEnter={this.requireAuth} />
            <Route path="/statusReimb" component={viewReimbursementByStatusComponent} onEnter={this.requireAuth} />
            <Route path="/authorReimb" component={viewMyReimbursementComponent} onEnter={this.requireAuth} />
            <Route path="/resolveReimb" component={resolveReimbursementComponent} onEnter={this.requireAuth} />
            {/* /myReimb, /idReimb, /statusReimb, /authorReimb do not have a navbar listing because 
            they will be accessed within the viewReimb page */}
          </Switch>
          </div>
        </>
      </BrowserRouter>
    );
  }
}

export default App;
