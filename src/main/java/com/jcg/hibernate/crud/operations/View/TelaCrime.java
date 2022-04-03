package com.jcg.hibernate.crud.operations.View;

import com.jcg.hibernate.crud.operations.Controller.CrimeCT;
import com.jcg.hibernate.crud.operations.Model.Crime;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaCrime extends JFrame implements ActionListener {
    public CrimeCT controle_crime = new CrimeCT();
    private JPanel contentPane;
    private JComboBox cbPesquisar;
    private ButtonGroup bt = new ButtonGroup();

    private JTextField txtDescricao;


    private JButton btnSalvar;
    private JButton btnExcluir;
    private JButton btnEditar;
    private JButton btnPesquisar;
    private JButton btnLimpar;

    public TelaCrime() {
        setTitle("Cadastro de Crime");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 556, 413);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblPesquisar = new JLabel("Pesquisar:");
        lblPesquisar.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        lblPesquisar.setBounds(10, 31, 109, 14);
        contentPane.add(lblPesquisar);

        JLabel lblNome = new JLabel("Descricao:");
        lblNome.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        lblNome.setBounds(10, 79, 109, 14);
        contentPane.add(lblNome);

        cbPesquisar = new JComboBox();
        cbPesquisar.setEditable(true);
        cbPesquisar.setBounds(129, 28, 283, 20);

        contentPane.add(cbPesquisar);

        txtDescricao = new JTextField();
        txtDescricao.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        txtDescricao.setBounds(129, 76, 283, 20);
        contentPane.add(txtDescricao);
        txtDescricao.setColumns(255);


        btnSalvar = new JButton("Incluir");
        btnSalvar.setBounds(193, 327, 75, 23);
        btnSalvar.addActionListener(this);
        btnSalvar.setActionCommand("salvar");
        contentPane.add(btnSalvar);

        btnEditar = new JButton("Editar");
        btnEditar.setBounds(280, 327, 75, 23);
        btnEditar.setText("Editar");
        btnEditar.addActionListener(this);
        btnEditar.setActionCommand("editar");
        contentPane.add(btnEditar);

        btnLimpar = new JButton("Limpar");
        btnLimpar.setBounds(360, 327, 75, 23);
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(this);
        btnLimpar.setActionCommand("limpar");
        contentPane.add(btnLimpar);

        btnExcluir = new JButton("");
        btnExcluir.setBounds(440, 327, 75, 23);
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(this);
        btnExcluir.setActionCommand("excluir");
        contentPane.add(btnExcluir);

        btnPesquisar = new JButton("Buscar");
        btnPesquisar.setBounds(422, 22, 80, 23);
        btnPesquisar.addActionListener(this);
        btnPesquisar.setActionCommand("pesquisar");
        contentPane.add(btnPesquisar);
        this.carregaListaCrime();
    }
    public Crime montaCrime(){
        //Pega os dados digitados nos campos do formulário e atribui ao objeto da classe Contato;
        Crime c = new Crime();
        c.setDescricao(this.txtDescricao.getText());
        return c;
    }
    public Crime editaCrime(int i){
        //Pega os dados digitados nos campos do formulário e atribui ao objeto da classe Contato;
        Crime c = new Crime();
        c.setDescricao(this.txtDescricao.getText());
        return c;
    }
    public void carregaCrimenaTela(Crime c2){
        //Pega os dados digitados nos campos do formulário e atribui ao objeto da classe Contato;
        this.txtDescricao.setText(c2.getDescricao());

    }

    public void limpaTela(){
        for(int i = 0; i < contentPane.getComponentCount(); i++){
            //laço de repetição percorrendo o contentPane - JPanel, o painel principal do form
            Component c = contentPane.getComponent(i);
            //Cria um objeto Component c que recebe o componente na posição i do laço for
            if(c instanceof JTextField){ //se o componente c for uma instância de JTextField
                JTextField campo = (JTextField) c;
                //cria uma variável JTextField recebendo o componente c com um cast
                campo.setText(null);
                //apaga o conteúdo do campo JTextField;
            }
        }

    }
    public void carregaListaCrime(){
        //Preenche Combobox com registros do banco de dados
        List<Crime> crimes = controle_crime.getCrimes();
        cbPesquisar.removeAllItems();
        for (Crime crime : crimes) {
            cbPesquisar.addItem(crime.getDescricao());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(this.btnSalvar.getActionCommand())) {
            //Condicional - se clicar no botão Salvar ...
            Crime c = this.montaCrime();
            //Chama o método montaContato para pegar os dados e gravar no objeto c;
            controle_crime.postCrime(c);
            this.limpaTela();
            //Limpa os campos após inserir/salvar dados no banco;
            this.carregaListaCrime();
            //Carrega a lista do combobox, atualizando após inserção;
            JOptionPane.showMessageDialog(null, "Contato " + txtDescricao.getText() + " cadastrado...");
            //Abre diálogo de mensagem, informando que o cliente foi cadastrado;
        } else if (e.getActionCommand().equals(this.btnPesquisar.getActionCommand())) {
            //Condicional - se clicar no botão buscar ...
            String descricaoDigitada = cbPesquisar.getSelectedItem().toString().trim();
            Crime cbusca = controle_crime.select(descricaoDigitada);
            if (cbusca.getDescricao().contains(descricaoDigitada.trim())) {
                JOptionPane.showMessageDialog(null, "Crime encontrado!");
                this.carregaCrimenaTela(cbusca);
            } else {
                JOptionPane.showMessageDialog(null, "Crime não cadastrado...");

            }
        } else if (e.getActionCommand().equals(this.btnLimpar.getActionCommand())) {
            this.limpaTela();
        } else if (e.getActionCommand().equals(this.btnExcluir.getActionCommand())) {
            //Condicional - se clicar no botão buscar ...
            Crime cbusca = controle_crime.select(cbPesquisar.getSelectedItem().toString());
            if (cbusca == null)
                JOptionPane.showMessageDialog(null, "Crime não cadastrado...");
            else {
                JOptionPane.showMessageDialog(null, "Crime excluido!");
                this.carregaCrimenaTela(cbusca);
                controle_crime.delete(cbusca);
                this.limpaTela();
                this.carregaListaCrime();
            }
        }
        if (e.getActionCommand().equals(this.btnEditar.getActionCommand())) {
            //Condicional - se clicar no botão buscar ...
            Crime cbusca = controle_crime.select(cbPesquisar.getSelectedItem().toString());
            if (cbusca == null)
                JOptionPane.showMessageDialog(null, "Crime não cadastrado...");
            else {
                JOptionPane.showMessageDialog(null, "Crime editado!");
                cbusca.setDescricao(txtDescricao.getText());
                controle_crime.update(this.editaCrime(cbusca.getId()));
                this.limpaTela();
                this.carregaListaCrime();
            }
        }
    }

}
