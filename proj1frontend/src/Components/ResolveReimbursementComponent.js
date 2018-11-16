import React from 'react';
import { ReimbursementTableComponent } from '../Components/ReimbursementTableComponent'

export class resolveReimbursementComponent extends React.Component {
  //for login functionality: If a user arrives at this component 
  // and has not yet logged in, they should be sent to sign-in component

  constructor(props) {
    super(props);
    this.state = { //change these for the new page
      id: 0,
      newStatus: 0
    }
  };

  submit = (event) => {
    console.log(this.state)
    if (this.state.newStatus === 0 || this.state.id === 0) {
      console.log("Pick a new status!")
    }
    else {


      fetch('http://localhost:8080/project1/reimbursements/resolve',
        {
          headers: { "Content-Type": "application/x-www-form-urlencoded" },
          method: "post",
          body: JSON.stringify({

            "reimb_id": this.state.id,
            "reimb_resolver": 1, //THIS IS A TEMPORARY HARD-CODE, WILL BE REPLACED WHEN LOGIN FUNCITONALITY IS IN PLACE
            "reimb_status_id": this.state.newStatus,
            "reimb_resolved": Date.now()
          })
        })
      console.log(this.state)
    }

  }


  update = (event) => {

    // if(event.target.id ==='amountInput')
    // {
    //   console.log("This is the amount")
    //   this.setState({
    //     ...this.state,
    //     amount: event.target.value
    //   })
    // }
    // if(event.target.id === 'descInput')
    // {
    //   this.setState({
    //     ...this.state,
    //     description: event.target.value
    //   })
    // }
    // if(event.target.id === 'receiptInput')
    // {
    //   this.setState({
    //     ...this.state,
    //     receipt: event.target.value
    //   })
    // }

    if (event.target.id === 'idInput') {
      this.setState({
        ...this.state,
        id: event.target.value
      })
    }
    if (event.target.id === 'statusInput') {
      this.setState({
        ...this.state,
        newStatus: event.target.value
      })
    }

  }

  render() {
    return (
      <div>
        <form>
          Reimbursement ID: <br></br>
          <input id="idInput" type="int" onChange={this.update}></input>{/*<button type="button" onClick={this.update}>Search By ID</button>*/} <br></br>
          {/* Reimbursement Description: <br></br>
          <input id="descInput" type="text" onChange={this.update}></input> <br></br>
          Reimbursement Receipt: <br></br>
          <input id="receiptInput" type="text" onChange={this.update}></input> <br></br> */}
          New Reimbursement Status: <br></br>
          <select className="form-control" id="statusInput" onChange={this.update}>
            <option value="1">Resolved</option>
            <option value="2">Denied</option>

          </select>

        </form>
        <button className="btn btn-primary" onClick={this.submit}>Submit</button>
        <ReimbursementTableComponent />
      </div>


    )
  }
}