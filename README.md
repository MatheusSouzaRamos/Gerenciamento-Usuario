# Gerenciamento-Usuario
Sistema de gerenciamento de usuários em Java, com interface e banco de dados. (ReadMe)

Neste projeto, foi desenvolvido um sistema simples de gerenciamento de usuários, utilizando a linguagem Java. O sistema integra-se com um banco de dados PostgreSQL para armazenar as informações dos usuários e utiliza o framework Swing (JFrame) para a construção da interface gráfica.

(Imagens do sistema disponíveis na pasta de Capturas de tela)

Distribução de pacotes:
Dao: contém as ações relacionadas ao banco de dados, como conexão, preparação e execução de requisições SQL.
Controllers: responsável pela lógica de programação por trás dos botões e ações da interface, gerenciando o fluxo do sistema.
ImagensView: pasta destinada ao armazenamento dos arquivos de imagens utilizados na interface.
View: armazena as classes referentes às telas JFrame, ou seja, a interface gráfica do sistema.
Model: contém as classes modelo utilizadas no sistema, em especial a classe usuário, incluindo construtores, getters, setters e demais métodos necessários.

O sistema é iniciado pela tela de login, onde o usuário pode acessar sua conta caso já possua uma credencial válida (nome de usuário e senha). Caso contrário, há um botão que redireciona para a tela de cadastro.

Na tela de cadastro, é possível registrar um novo usuário, sendo obrigatório o preenchimento de todos os campos. O sistema valida se as senhas informadas são idênticas e verifica se o nome de usuário já está cadastrado no banco de dados. Em caso de erro, são exibidas caixas de diálogo com mensagens explicativas, indicando o que precisa ser corrigido para concluir o cadastro com sucesso.

Após o login, o sistema exibe uma tela de menu com três funcionalidades principais: consulta, edição e deleção de usuários.

Na tela de consultas, há um botão que permite atualizar a tabela exibida, a qual contém as informações de ID (gerado automaticamente por autoincremento) e nome dos usuários cadastrados. Também está disponível um campo de pesquisa que permite realizar consultas simultâneas por ID ou nome de usuário, facilitando a localização de registros específicos.

Essa tela pode ser utilizada de forma simultânea com as demais funcionalidades (edição e deleção), permitindo ao usuário acompanhar, em tempo real, as alterações realizadas no sistema.

Na tela de edição, é obrigatório informar o nome de usuário e a senha atual para realizar qualquer alteração. O sistema permite modificar o nome de usuário (desde que o novo nome ainda não esteja em uso) e a senha, sendo necessário que a nova senha seja confirmada corretamente.

Em caso de inconsistência nos dados informados, como senhas não coincidentes ou nome de usuário já existente, o sistema exibe caixas de diálogo com mensagens explicativas, orientando o usuário sobre como corrigir o problema.

Por fim, na tela de deleção, é possível remover um usuário do sistema mediante a confirmação de suas credenciais. Para isso, o usuário deve informar o nome de usuário, a senha e confirmá-la corretamente. O sistema valida essas informações antes de efetuar a exclusão e, em caso de erro ou inconsistência, exibe caixas de diálogo com mensagens orientativas.
