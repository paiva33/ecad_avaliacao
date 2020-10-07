import React, {Component} from 'react'
import moment from 'moment'
import ArquivoDataService from '../../api/ArquivoDataService'

// Imports antd components
import { Table, Tag, DatePicker, Space } from 'antd';




// Import reactstrap components
import { 
  Container, 
  Row, 
  Col, 
  Button, 
  Form, 
  FormGroup, 
  Label, 
  Input, 
  Card, 
  CardHeader, 
  CardFooter, 
  CardBody,
  CardTitle, 
  CardText  } from 'reactstrap';

// import { Formik, Form, Field, ErrorMessage } from 'formik'


class ArquivoComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            arquivos: [],
            search: {
                boleto: '',
                nossoNumero: '',
                dataInicial: null,
                dataFinal: null,
                banco: 'SANTANDER',
                tipoArquivo: 'RET'
            },
            tiposArquivo: ['RET','REM'],
            bancos: ['BRADESCO', 'SANTANDER']
        }

        this.search = this.search.bind(this)
        this.handleChangeBanco = this.handleChangeBanco.bind(this)
        this.handleChangeDataInicial = this.handleChangeDataInicial.bind(this)
        this.handleChangeDataFinal = this.handleChangeDataFinal.bind(this)
        this.handleChangeTipo = this.handleChangeTipo.bind(this)
    }

    search() {
        ArquivoDataService.search(this.state.search)
                .then(response => {
                    this.setState({arquivos: response.data.content})
                })
    }

    handleChangeDataInicial(event) {
        this.setState({search: {dataInicial: event.target.value}})
    }

    handleChangeDataFinal(event) {
        this.setState({search: {dataFinal: event.target.value}})
    }

    componentDidMount() {
        this.setState({})
        this.search()
    }

    handleSubmit(event) {
        this.search();
        event.preventDefault();
    }
    

    handleChangeBanco(event) {
        this.setState({search : {banco:  event.target.value}})
    }

    handleChangeTipo(event) {
        this.setState({search: {tipoArquivo: event.target.value}})
    }

    render() {

        let {arquivos, search, bancos, tiposArquivo} = this.state

        console.log(search);
        return (
            <>
                <Container className="themed-container" fluid={true} style={{padding: "20px"}}>
                    <Row>
                    <form onSubmit={this.handleSubmit} style={{width: '100%'}}>
                        <Card style={{width: "100%"}}>
                            <CardHeader>Filtro de pesquisa</CardHeader>
                            <CardBody>
                                <div className="form-row">

                                    <div className="col-3">
                                        <label className="p-3">Boleto: </label>
                                        <span className="p-5"><input value={search.boleto}></input></span>
                                    </div>
                                    
                                    <div className="col-3">
                                        <label className="p-1">Nosso número: </label>
                                        <span className="p-5"><input value={search.nossoNumero}></input></span>
                                    </div>
                                </div>
                                <div className="form-row">
                                    <div className="col-3">
                                            <label className="p-1">Data inicial: </label>
                                            <span className="p-5">
                                                <DatePicker value={search.dataInicial} onChange={this.handleChangeDataInicial} />                                                
                                            </span>
                                    </div>
                                    <div className="col">
                                        <label className="p-2">Data final: </label>
                                        <span className="p-5"><DatePicker value={search.dataFinal} onChange={this.handleChangeDataFinal} /></span>
                                    </div>
                                </div>
                                <div className="form-row">
                                    <div className="col-2">
                                        <label className="p-1">Banco: </label>
                                        <span className="p-8">
                                            <select value={search.banco} onChange={this.handleChangeBanco}>
                                                <option>SANTANDER</option>                                  
                                                <option>BRADESCO</option>
                                            </select>
                                        </span>                                        
                                    </div> 
                                    <div className="col-2">
                                        <label className="p-1">Arquivo: </label>
                                        <span className="p-3">
                                            <select  value={search.tipoArquivo} onChange={this.handleChangeTipo}>
                                                <option>RET</option>
                                                <option>REC</option>                                     
                                            </select>
                                        </span>
                                    </div>
                                </div>                                                                                    
                            </CardBody>
                            <CardFooter>
                                <div className="float-right"><button  className="btn btn-primary" type="submit">Pesquisar</button></div>
                            </CardFooter>
                        </Card>
                    </form>     
                    </Row>
                    <br />
                    <Row>
                        <table className="table table-striped table-bordered">
                                <thead>
                                    <tr>
                                        <th>Banco</th>
                                        <th>Tipo</th>
                                        <th>Arquivo</th>
                                        <th>Dt. Geração</th>
                                        <th>Gerado por</th>
                                        <th>Dt. Envio</th>
                                        <th>Qtd. Linhas</th>
                                        <th>Carteira</th>
                                        <th>Vlr. Total</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {arquivos && arquivos.map(arquivo =>
                                        <tr key={arquivo.id}>
                                            <td>{arquivo.banco}</td>
                                            <td>{arquivo.tipo}</td>
                                            <td>{arquivo.nome}</td>
                                            <td>{arquivo.dtGeracao}</td>
                                            <td>{arquivo.geradoPor}</td>
                                            <td>{arquivo.dtEnvio}</td>
                                            <td>{arquivo.qtdLinhas}</td>
                                            <td>{arquivo.carteiras}</td>
                                            <td>{arquivo.valorTotal}</td>
                                        </tr>
                                    )}
                                </tbody>
                        </table>                     
                    </Row>
                    <br />                    
                </Container>
            </>
        )
    }

}


export  {ArquivoComponent}