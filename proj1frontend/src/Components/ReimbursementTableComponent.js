import React from 'react';
import PropTypes from 'prop-types';
import { Link } from 'react-router-dom';

export class ReimbursementTableComponent extends React.PureComponent {


    constructor(props) {
        super(props);
        this.state = {
            reimbs: [],
            count: 1,
            authorId: 0,
            reimbId: 0
        }
    };

    // timeDisplay() //this works, but I need to figure out how to link the output into the table
    // {
    //     var tempDate = this.state.reimbs.reimb_submitted
    //     var date = tempDate.getFullYear() + '-' + (tempDate.getMonth()+1) + '-' + tempDate.getDate() +' '+ tempDate.getHours()+':'+ tempDate.getMinutes()+':'+ tempDate.getSeconds();

    //     return (
    //       date
    //     );
    // }
    update = (event) => {

        if (event.target.id === 'byAuthorText') {
            this.setState({
                ...this.state,
                authorId: event.target.value

            })
            console.log(this.state.authorId)
        }
        if(event.target.id === 'byIdText')
        {
            this.setState({
                ...this.state,
                reimbId: event.target.value
            })
            
        }

        console.log(this.state)

    }

    sort = (event) => {
        if (event.target.id === "byAuthor") {
            let fetchUrl = 'http://localhost:8080/project1/reimbursements/author/' + this.state.authorId
            fetch(fetchUrl) // find by author isn't implemented just yet
                .then(res => res.json())
                .then(data => {


                    this.setState({
                        ...this.state,
                        reimbs: data
                    })
                    console.log(this.state)

                })
                .catch(err => {
                    console.log(err);
                });

        }
        if (event.target.id === "byID") {
            let fetchUrl = 'http://localhost:8080/project1/reimbursements/' + this.state.reimbId
            fetch(fetchUrl) // find by author isn't implemented just yet
                .then(res => res.json())
                .then(data => {


                    this.setState({
                        ...this.state,
                        reimbs: data
                    })

                })
                .catch(err => {
                    console.log(err);
                });
        }
    }


    componentDidMount() {

        fetch('http://localhost:8080/project1/reimbursements/') // need to find the correct URL here
            .then(res => res.json())
            .then(data => {


                this.setState({
                    ...this.state,
                    reimbs: data
                })

            })
            .catch(err => {
                console.log(err);
            });

    };

    render() {
        return (
            <div id="reimb-row">
                <input id="byAuthorText" type="text" onChange={this.update}></input>
                <button id="byAuthor" className="btn btn-primary" onClick={this.sort}>Search By Author ID</button>
                <input id="byIdText" type="text" onChange={this.update}></input>
                <button id="byID" className="btn btn-primary" onClick={this.sort}>Search By Request ID</button>
                <Link to='/newReimb'><button id="CreateNew" className="btn btn-success">Create a New Request</button></Link>
                {/* <button className="btn btn-primary" onClick = {this.submit}>Search By ID</button> */}
                <table className="table table-bordered" >
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">amount</th>
                            <th scope="col">submitted</th>
                            <th scope="col">Resolved</th>
                            <th scope="col">Description</th>
                            <th scope="col">Reciept</th>
                            <th scope="col">Author ID</th>
                            <th scope="col">Resolver ID</th>
                            <th scope="col">status ID</th>
                            <th scope="col">Type ID</th>
                        </tr>
                    </thead>
                    <tbody id="reimb-container">
                        {this.state.reimbs.map((reimb, index) => ( //we don't use index here for this project. Safe to remove?
                            <tr>
                                {/* <th scope="row">{index + 1}</th> */}
                                <td>{reimb.reimb_id}</td>
                                <td>{reimb.reimb_amount}</td>
                                <td>{reimb.reimb_submitted}</td>
                                <td>{reimb.reimb_resolved}</td>
                                <td>{reimb.reimb_description}</td>
                                <td>{reimb.reimb_receipt}</td>
                                <td>{reimb.reimb_author}</td>
                                <td>{reimb.reimb_resolver}</td>
                                <td>{reimb.reimb_status_id}</td>
                                <td>{reimb.reimb_type_id}</td>

                            </tr>
                        ))}

                    </tbody>
                </table>
            </div>
        )
    };
}