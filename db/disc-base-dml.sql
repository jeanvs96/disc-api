--roles
insert into disc.roles (role_name) values ('ADMIN');
insert into disc.roles (role_name) values ('USER');
insert into disc.roles (role_name) values ('VERIFIED_USER');

--education-level

insert into disc.education_level (education_level) values('Ensino Médio Incompleto');
insert into disc.education_level (education_level) values('Cursando Ensino Médio');
insert into disc.education_level (education_level) values('Ensino Médio Completo');
insert into disc.education_level (education_level) values('Cursando Ensino Superior');
insert into disc.education_level (education_level) values('Ensino Superior Completo');

--test

insert into disc.tests (name) values ('persona01');

--questions

INSERT INTO disc.questions
(question_id, question, test_id)
VALUES(1, 'Me define melhor:', 1);
INSERT INTO disc.questions
(question_id, question, test_id)
VALUES(2, 'Ao lidar com desconhecidos:', 1);
INSERT INTO disc.questions
(question_id, question, test_id)
VALUES(3, 'Eu me considero uma pessoa:', 1);
INSERT INTO disc.questions
(question_id, question, test_id)
VALUES(4, 'Eu sou mais:', 1);
INSERT INTO disc.questions
(question_id, question, test_id)
VALUES(5, 'Em situações desafiadoras eu costumo agir de maneira:', 1);
INSERT INTO disc.questions
(question_id, question, test_id)
VALUES(6, 'Costumo ser:', 1);
INSERT INTO disc.questions
(question_id, question, test_id)
VALUES(7, 'As pessoas me vêm como:', 1);
INSERT INTO disc.questions
(question_id, question, test_id)
VALUES(8, 'Também dizem que sou:', 1);
INSERT INTO disc.questions
(question_id, question, test_id)
VALUES(9, 'Consigo facilmente:', 1);
INSERT INTO disc.questions
(question_id, question, test_id)
VALUES(10, 'Também posso ser:', 1);
INSERT INTO disc.questions
(question_id, question, test_id)
VALUES(11, 'Quando alguém faz algo que não me agrada:', 1);
INSERT INTO disc.questions
(question_id, question, test_id)
VALUES(12, 'Eu naturalmente sou:', 1);
INSERT INTO disc.questions
(question_id, question, test_id)
VALUES(13, 'Em um jogo ou competição:', 1);
INSERT INTO disc.questions
(question_id, question, test_id)
VALUES(14, 'A característica que mais admiro em mim é:', 1);
INSERT INTO disc.questions
(question_id, question, test_id)
VALUES(15, 'Eu me destaco por ser:', 1);
INSERT INTO disc.questions
(question_id, question, test_id)
VALUES(16, 'Outra caracerística minha é:', 1);
INSERT INTO disc.questions
(question_id, question, test_id)
VALUES(17, 'Também sou visto como:', 1);
INSERT INTO disc.questions
(question_id, question, test_id)
VALUES(18, 'Eu facilmente posso ser:', 1);
INSERT INTO disc.questions
(question_id, question, test_id)
VALUES(19, 'Com frequência me sinto:', 1);
INSERT INTO disc.questions
(question_id, question, test_id)
VALUES(20, 'Frequentemente sou:', 1);
INSERT INTO disc.questions
(question_id, question, test_id)
VALUES(21, 'Sou mais:', 1);
INSERT INTO disc.questions
(question_id, question, test_id)
VALUES(22, 'Posso ser:', 1);
INSERT INTO disc.questions
(question_id, question, test_id)
VALUES(23, 'Sou mais:', 1);
INSERT INTO disc.questions
(question_id, question, test_id)
VALUES(24, 'Também posso ser:', 1);
INSERT INTO disc.questions
(question_id, question, test_id)
VALUES(25, 'Tenho medo de:', 1);

--answers

INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(1, 'Sou autoconfiante', 'D', 1);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(2, 'Influencio pessoas', 'I', 1);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(3, 'Dificilmente me irrito', 'S', 1);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(4, 'Sou preocupado', 'C', 1);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(5, 'Sou ousado', 'D', 2);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(6, 'Sou carismático', 'I', 2);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(7, 'Sou empático', 'S', 2);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(8, 'Sou cauteloso', 'C', 2);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(9, 'Sem medo de correr riscos', 'D', 3);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(10, 'Relacional e Falante', 'I', 3);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(11, 'Tranquilo e Paciente', 'S', 3);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(12, 'Cuidadoso e Discreto', 'C', 3);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(13, 'Aventureiro', 'D', 4);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(14, 'Otimista', 'I', 4);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(15, 'Prestativo', 'S', 4);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(16, 'Observador', 'C', 4);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(17, 'Ágil e Impaciente', 'D', 5);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(18, 'Otimista e Confiante', 'I', 5);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(19, 'Comedida e Modesta', 'S', 5);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(20, 'Cuidadosa e Organizada', 'C', 5);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(21, 'Seguro e determinado', 'D', 6);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(22, 'Divertido', 'I', 6);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(23, 'Bom membro de equipe', 'S', 6);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(24, 'Racional', 'C', 6);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(25, 'Destemido', 'D', 7);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(26, 'Amigo de todos', 'I', 7);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(27, 'Estável', 'S', 7);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(28, 'Inteligente', 'C', 7);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(29, 'Competitivo', 'D', 8);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(30, 'Expansivo', 'I', 8);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(31, 'Pensativo', 'S', 8);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(32, 'Exigente', 'C', 8);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(33, 'Ser enérgico', 'D', 9);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(34, 'Socializar', 'I', 9);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(35, 'Ajudar as pessoas', 'S', 9);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(36, 'Analisar coisas e situações', 'C', 9);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(37, 'Independente e Agressivo', 'D', 10);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(38, 'Desinibido e Exagerado', 'I', 10);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(39, 'Cooperador e Lento', 'S', 10);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(40, 'Ponderado e Medroso', 'C', 10);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(41, 'Sou direto e sincero', 'D', 11);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(42, 'Falo sem parar', 'I', 11);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(43, 'Guardo para mim', 'S', 11);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(44, 'Sou crítico e detalhista', 'C', 11);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(45, 'Firme ao tomar decisões', 'D', 12);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(46, 'Falante', 'I', 12);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(47, 'Conservador', 'S', 12);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(48, 'Controlado', 'C', 12);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(49, 'Sou persistente e competitivo, o foco é vencer', 'D', 13);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(50, 'Sou animado e divertido, o importante é competir', 'I', 13);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(51, 'Gosto de jogos em equipe, cooperar é meu forte', 'S', 13);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(52, 'Sou disciplinado e focado, não gosto de errar', 'C', 13);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(53, 'Autocofiança', 'D', 14);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(54, 'Sociabilidade', 'I', 14);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(55, 'Paciência', 'S', 14);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(56, 'Disciplina', 'C', 14);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(57, 'Ousado', 'D', 15);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(58, 'Persuasivo', 'I', 15);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(59, 'Gentil', 'S', 15);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(60, 'Exigente', 'C', 15);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(61, 'Vigor', 'D', 16);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(62, 'Carisma', 'I', 16);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(63, 'Generosidade', 'S', 16);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(64, 'Perfeccionismo', 'C', 16);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(65, 'Sem papas na língua', 'D', 17);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(66, 'Bem-humorado', 'I', 17);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(67, 'Bom ouvinte', 'S', 17);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(68, 'Reservado', 'C', 17);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(69, 'Determinado', 'D', 18);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(70, 'Otimista e animado', 'I', 18);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(71, 'Prestativo', 'S', 18);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(72, 'Detalhista', 'C', 18);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(73, 'Determinado', 'D', 19);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(74, 'Atraente', 'I', 19);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(75, 'Calmo', 'S', 19);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(76, 'Preocupado', 'C', 19);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(77, 'Inquieto', 'D', 20);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(78, 'Popular', 'I', 20);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(79, 'Acolhedor', 'S', 20);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(80, 'Cauteloso', 'C', 20);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(81, 'Decidido', 'D', 21);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(82, 'Incentivador', 'I', 21);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(83, 'Agradável', 'S', 21);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(84, 'Desconfiado', 'C', 21);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(85, 'Desafiador', 'D', 22);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(86, 'Festeiro', 'I', 22);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(87, 'Tranquilo', 'S', 22);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(88, 'Critico', 'C', 22);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(89, 'Corajoso', 'D', 23);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(90, 'Sonhador', 'I', 23);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(91, 'Planejador', 'S', 23);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(92, 'Formal', 'C', 23);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(93, 'Atrevido', 'D', 24);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(94, 'Brincalhão', 'I', 24);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(95, 'Sereno', 'S', 24);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(96, 'Organizado', 'C', 24);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(97, 'Ser enganado', 'D', 25);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(98, 'Ser rejeitado', 'I', 25);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(99, 'Perder o controle', 'S', 25);
INSERT INTO disc.answers
(answer_id, answer, factor, question_id)
VALUES(100, 'Ser criticado', 'C', 25);

--main-factor-description

INSERT INTO disc.main_factor_description
(main_factor_description_id, factor, title, description, positive_points, improvement_points, keywords)
VALUES(1, 'D', 'Dominância', 'São pessoas competitivas e determinadas, voltadas a atingir objetivos e a atuar com foco em entregas e resultados. Exigentes, racionais, com tendência a comportamentos autoritários, podem querer controlar e dominar tudo a sua volta. Geralmente, se comunicam de forma direta e franca, não pensam muito antes de falar, chegam a interromper os outros. Gostam de desafios e lidam melhor com tarefas do que com pessoas. São motivados por liberdade, autonomia, autoridade, crescimento e desafios. Podem passar a impressão de um perfil corajoso, imparável e obstinado; por outro lado, podem parecer arrogantes, argumentativos e agressivos.', 'Grande capacidade de iniciar coisas, foco em resultados e metas, competividade, capacidade para lidar com grandes desafios.', 'Dificuldade para ouvir, impaciência, excesso de controle e de debates, autoritarismo, pouco planejamento.', 'Aventura; Competição; Iniciativa; Determinação; Agressividade; Objetividade; Impaciência.');
INSERT INTO disc.main_factor_description
(main_factor_description_id, factor, title, description, positive_points, improvement_points, keywords)
VALUES(2, 'I', 'Influência', 'São pessoas comunicativas e extrovertidas, voltadas à interação. Possuem grande facilidade para conhecer pessoas e ampliar a sua rede de contatos. Costumam se comunicar de forma alegre, são persuasivas e convincentes, ou seja. possuem facilidade para vender suas ideias. Gostam de lidar com pessoas e são motivadas por reconhecimento social e popularidade, sendo assim, preferem um ambiente de trabalho descontraído e leve. Podem passar a impressão de um perfil divertido, informal, popular; por outra lado, podem parecer superficiais, exagerados e até prolixos.', 'Criatividade, motivação de pessoas, trabalho em equipe, negociação, persuasão, bom humor.', 'Impulsividade, sentimentalismo, falta de atenção a detalhes, excesso de expressões faciais, falar demais, pouco planejamento.', 'Carisma; Comunicação; Encantamento; Persuasão; Vaidade;  Espontaneidade; Expansividade.');
INSERT INTO disc.main_factor_description
(main_factor_description_id, factor, title, description, positive_points, improvement_points, keywords)
VALUES(3, 'S', 'Estabilidade', 'São pessoas tranquilas, com habilidade para ouvir e pensar antes de falar, são cooperativas e termimam o que começam. Possuem tendência à cautela, por isso, precisam de mais tempo do que os demais para concluir tarefas. Costumam se comunicar de forma indireta. educada, cordial e atenciosa. Gostam de pessoas e de estabilidade. Suas relações profissionais ou pessoais são de longa duração. São motivados por harmonia, identificação com o ambiente e com as pessoas, procedimentos estruturados, e valorização do seu compromisso e lealdade. Podem passar a impressão de calma e serenidade; por outro lado, podem parecer instrospectivos e resistentes a mudanças.', 'rabalho em equipe,  dedicação a uma causa ou liderança, paciência para atuar em situações complexas, terminar o que começa, saber ouvir.', 'Resistência a mudanças, pouca iniciativa, tensão para lidar com críticas, baixo senso de urgência, autonomia limitada.', 'Acolhimento; Calma; Cooperação; Consistência; Possessividade; Previsibilidade; Sistematização.');
INSERT INTO disc.main_factor_description
(main_factor_description_id, factor, title, description, positive_points, improvement_points, keywords)
VALUES(4, 'C', 'Conformidade', 'São pessoas altamente voltadas a detalhes, precisão e qualidade, com forte tendência a exigir demais tanto de si, quanto dos outros. Buscam a perfeição e, por isso, tendem a focar demais no que pode dar errado. Tendem a um perfil mais instrospectivo e costumam se comunicar de forma direta e objetiva. No entanto, podem ser detalhistas ao falar de aspectos relacionados a procedimentos ou direcionamentos. Gostam de ambientes com normas e regras claras, e preferem atuar com tarefas do que com pessoas. São motivados por procedimentos estruturados, qualidade, tempo para pensar e agir, e acesso a informações. Podem ser vistos como pessoas preocupadas e pessismistas;  por outro lado, passam a impressão de indivíduos focados, estudiosos e cheios de conteúdo.', 'Pensamento crítico, altos padrões de qualidade, foco, cuidado e atenção a detalhes.', 'Analisar demais, excesso de críticas, exigência e preocupação, perfil retraído.', 'Análise; Cautela; Conformidade; Qualidade; Formalidade; Instrospecção; Exigência.');

--factor-combination-description

INSERT INTO disc.factor_combination_description
(factor_combination_id, factor_combination, title, description, "characteristics", strengths, challenges, combination_details, stands_out)
VALUES(1, 'Di', 'DETERMINAÇÃO', 'Ao lidar com situações complexas, não espera apoio ou supervisão para atuar, costuma agir de maneira independente e objetiva. Sua comunicação é direta, por vezes incisiva, do tipo que argumenta, debate, tenta vencer a discussão e é dificilmente influenciado.', '<ul>
        <li><strong>Líder nato</strong>, que busca resultados com energia e ousadia.</li>
      <li><strong>Influente, mas direto</strong>: usa carisma como ferramenta para alcançar metas.</li>
      <li><strong>Movido a desafios</strong>: gosta de superar obstáculos e avançar rapidamente.</li>
      <li><strong>Confiante e assertivo</strong>: tende a tomar decisões com rapidez e iniciativa.</li>
</ul>', '<ul>
      <li>Alta capacidade de liderança e persuasão.</li>
      <li>Decisão rápida e senso de urgência.</li>
      <li>Facilidade em motivar e engajar pessoas em torno de objetivos.</li>
      <li>Combina ousadia com carisma.</li>
    </ul>', '<ul>
      <li>Pode agir com impulsividade ou impaciência.</li>
      <li>Corre risco de ignorar detalhes ou processos ao buscar resultados.</li>
      <li>Tem tendência a ser dominante demais em discussões.</li>
      <li>Em contextos mais rígidos, pode se frustrar com burocracias.</li>
    </ul>', '<ul>
<li><strong>Alta Dominância (D)</strong>: direto, decidido, competitivo, voltado a resultados.</li>
      <li><strong>Influência moderada (i)</strong>: sociável e persuasivo, mas de forma secundária.</li>
</ul>', '<ul>
      <li>Ambientes que exigem iniciativa e liderança ágil.</li>
      <li>Empreendedorismo e startups.</li>
      <li>Vendas e negociações de impacto.</li>
      <li>Gestão de equipes com foco em crescimento acelerado.</li>
    </ul>');
INSERT INTO disc.factor_combination_description
(factor_combination_id, factor_combination, title, description, "characteristics", strengths, challenges, combination_details, stands_out)
VALUES(2, 'DS', 'FOCO EM RESULTADOS', 'Trata-se de uma pessoa focada em atingir resultados e resolver problemas. Lidar com desafios é algo que gera motivação para esse indivíduo. É comum que esse perfil tenha uma mente agitada, mas o corpo geralmente seja mais relaxado.', '<ul>
        <li><strong>Assertivo, mas controlado</strong>: combina impulso de ação com cautela e análise.</li>
      <li><strong>Decide com firmeza, mas sem pressa</strong>: pondera antes de agir, porém mantém o foco em metas.</li>
      <li><strong>Persistente e disciplinado</strong>: trabalha com foco, constância e determinação.</li>
      <li><strong>Estável sob pressão</strong>: mantém o controle emocional mesmo em ambientes desafiadores.</li>
</ul>', '<ul>
      <li>Alta resiliência e estabilidade emocional.</li>
      <li>Determinação silenciosa: firmeza sem necessidade de impor.</li>
      <li>Capacidade de liderar com equilíbrio e constância.</li>
      <li>Foco em metas de longo prazo com pragmatismo.</li>
    </ul>', '<ul>
      <li>Pode ter dificuldade em lidar com mudanças muito rápidas ou caóticas.</li>
      <li>Tende a ser reservado, o que pode ser interpretado como frieza.</li>
      <li>Em ambientes de alta pressão, pode internalizar conflitos em vez de expressá-los.</li>
      <li>Corre o risco de ser inflexível quando decide algo.</li>
    </ul>', '<ul>
<li><strong>Alta Dominância (D)</strong>: decidido, assertivo, voltado a resultados, direto.</li>
      <li><strong>Alta Estabilidade (S)</strong>: paciente, consistente, focado em segurança e previsibilidade.</li>
</ul>', '<ul>
      <li>Gestão de operações ou projetos de médio/longo prazo.</li>
      <li>Ambientes que exigem liderança estável e tomada de decisão estruturada.</li>
      <li>Empresas com processos consolidados que valorizam firmeza e consistência.</li>
      <li>Áreas de logística, planejamento estratégico e processos industriais.</li>
    </ul>');
INSERT INTO disc.factor_combination_description
(factor_combination_id, factor_combination, title, description, "characteristics", strengths, challenges, combination_details, stands_out)
VALUES(3, 'DI', 'INICIATIVA', 'É comum ser direto ao se comunicar, suas falas carregam um tom de objetividade. Tem capacidade para solucionar problemas, mas costuma envolver mais pessoas quando está frente a desafios. Geralmente é do tipo contestador e direto, mas tem seus momentos de descontração e simpatia, o que traz certa ambiguidade ao perfil. ', '<ul>
      <li><strong>Líder nato</strong>, que busca resultados com energia e ousadia.</li>
      <li><strong>Influente, mas direto</strong>: usa carisma como ferramenta para alcançar metas.</li>
      <li><strong>Movido a desafios</strong>: gosta de superar obstáculos e avançar rapidamente.</li>
      <li><strong>Confiante e assertivo</strong>: tende a tomar decisões com rapidez e iniciativa.</li>
    </ul>', '<ul>
      <li>Alta capacidade de liderança e persuasão.</li>
      <li>Decisão rápida e senso de urgência.</li>
      <li>Facilidade em motivar e engajar pessoas em torno de objetivos.</li>
      <li>Combina ousadia com carisma.</li>
    </ul>', '<ul>
      <li>Pode agir com impulsividade ou impaciência.</li>
      <li>Corre risco de ignorar detalhes ou processos ao buscar resultados.</li>
      <li>Tem tendência a ser dominante demais em discussões.</li>
      <li>Em contextos mais rígidos, pode se frustrar com burocracias.</li>
    </ul>', '<ul>
      <li><strong>Alta Dominância (D)</strong>: direto, decidido, competitivo, voltado a resultados.</li>
      <li><strong>Influência moderada (i)</strong>: sociável e persuasivo, mas de forma secundária.</li>
    </ul>', '<ul>
      <li>Ambientes que exigem iniciativa e liderança ágil.</li>
      <li>Empreendedorismo e startups.</li>
      <li>Vendas e negociações de impacto.</li>
      <li>Gestão de equipes com foco em crescimento acelerado.</li>
    </ul>');
INSERT INTO disc.factor_combination_description
(factor_combination_id, factor_combination, title, description, "characteristics", strengths, challenges, combination_details, stands_out)
VALUES(4, 'Ds', 'AUTOSUPERAÇÃO', 'São pessoas bastante competitivas, focadas em superação. Com isso, podem ser agitadas e ansiosas, convivem com uma certa  tensão constante, o que pode se transformar em quadros de ansiedade. A pressa é algo que faz parte desse perfil, estão sempre preocupados com o relógio.', '<ul>
      <li><strong>Focado e pragmático</strong>: pensa no que precisa ser feito e executa com firmeza.</li>
      <li><strong>Persistente e disciplinado</strong>: trabalha com constância rumo aos resultados.</li>
      <li><strong>Direto, porém controlado</strong>: tende a ser mais calmo do que um D puro, mas ainda assertivo.</li>
      <li><strong>Mais reservado</strong>: prefere ações concretas a falas extensas, tende a ser contido emocionalmente.</li>
    </ul>', '<ul>
      <li>Combinação de determinação com paciência estratégica.</li>
      <li>Capacidade de manter o foco em metas de longo prazo.</li>
      <li>Trabalha bem sob pressão sem perder a compostura.</li>
      <li>Execução confiável com baixa necessidade de supervisão.</li>
    </ul>', '<ul>
      <li>Pode parecer frio ou distante em interações sociais.</li>
      <li>Resistência a mudanças inesperadas ou improvisações.</li>
      <li>Tem tendência a insistir em decisões já tomadas, mesmo diante de novas informações.</li>
      <li>Pode demorar a pedir ajuda, preferindo resolver tudo sozinho.</li>
    </ul>', '<ul>
      <li><strong>Alta Dominância (D)</strong>: decidido, direto, orientado a metas, firme nas decisões.</li>
      <li><strong>Estabilidade moderada (s)</strong>: consistente, focado em rotina e previsibilidade, porém menos dominante.</li>
    </ul>', '<ul>
      <li>Ambientes que valorizam persistência, constância e resultados sólidos.</li>
      <li>Gestão de times operacionais ou técnicos com foco em performance.</li>
      <li>Projetos de execução metódica com metas bem definidas.</li>
      <li>Funções que exigem controle, responsabilidade e firmeza.</li>
    </ul>');
INSERT INTO disc.factor_combination_description
(factor_combination_id, factor_combination, title, description, "characteristics", strengths, challenges, combination_details, stands_out)
VALUES(5, 'Dc', 'INDEPENDÊNCIA', 'Essa pessoa é, geralmente, corajosa e ousada, não tem medo de correr riscos, é visto como aventureiro e também iniciador de coisas. Ao lidar com problemas, tende a trazer um olhar mais independente e determinado, não se apega muito aos obstáculos para solucioná-los, apenas mantém o seu foco em resolvê-los.', '<ul>
      <li><strong>Decidido e técnico</strong>: toma decisões rápidas, mas com atenção aos detalhes relevantes.</li>
      <li><strong>Foco em desempenho e excelência</strong>: busca alta performance com exigência e critérios claros.</li>
      <li><strong>Analítico e direto</strong>: comunica com objetividade e tende a ser exigente com os outros.</li>
      <li><strong>Líder controlador</strong>: prefere manter o controle sobre processos e decisões.</li>
    </ul>', '<ul>
      <li>Forte capacidade de liderança e foco em resultados.</li>
      <li>Boa combinação de visão estratégica com atenção a normas e padrões.</li>
      <li>Alta exigência consigo mesmo e com a equipe.</li>
      <li>Eficiência na resolução de problemas e tomada de decisão lógica.</li>
    </ul>', '<ul>
      <li>Pode ser visto como autoritário ou inflexível.</li>
      <li>Tende a assumir o controle e resistir a delegar.</li>
      <li>Pode ser impaciente com erros ou processos lentos.</li>
      <li>Corre o risco de valorizar mais resultados do que relacionamentos.</li>
    </ul>', '<ul>
      <li><strong>Alta Dominância (D)</strong>: determinado, orientado a resultados, direto e competitivo.</li>
      <li><strong>Conformidade moderada (c)</strong>: atento a regras, precisão e controle, mas sem rigidez excessiva.</li>
    </ul>', '<ul>
      <li>Ambientes de alta performance e competitividade.</li>
      <li>Empresas que valorizam resultados mensuráveis e disciplina operacional.</li>
      <li>Projetos com metas claras, pressão por prazos e controle de qualidade.</li>
      <li>Áreas técnicas, estratégicas ou de liderança em contextos complexos.</li>
    </ul>');
INSERT INTO disc.factor_combination_description
(factor_combination_id, factor_combination, title, description, "characteristics", strengths, challenges, combination_details, stands_out)
VALUES(6, 'DC', 'QUALIDADE', 'São pessoas que conseguem assumir riscos, mas sempre de forma calculada e, até mesmo, podem tomar decisões em climas incertos, porém mediante análise. No entanto, detestam perder ou errar, geralmente são muito exigentes consigo e com os demais.', '<ul>
      <li><strong>Líder exigente e estratégico</strong>: busca excelência e resultados com base em regras bem definidas.</li>
      <li><strong>Competitivo e técnico</strong>: atua com foco e assertividade, mas também com lógica e análise.</li>
      <li><strong>Perfecionista com senso de urgência</strong>: quer tudo certo e rápido.</li>
      <li><strong>Comunicação direta e objetiva</strong>: não perde tempo com rodeios ou informalidades desnecessárias.</li>
    </ul>', '<ul>
      <li>Altíssimo padrão de exigência e qualidade.</li>
      <li>Capacidade de tomar decisões difíceis com base em fatos.</li>
      <li>Liderança firme, técnica e respeitada.</li>
      <li>Excelente em análises complexas e controle de performance.</li>
    </ul>', '<ul>
      <li>Pode ser excessivamente crítico ou inflexível.</li>
      <li>Corre risco de criar um ambiente controlador e tenso.</li>
      <li>Tende a ser impaciente com quem não acompanha seu ritmo ou padrão.</li>
      <li>Dificuldade em lidar com incertezas ou improvisos.</li>
    </ul>', '<ul>
      <li><strong>Alta Dominância (D)</strong>: assertivo, direto, orientado a resultados, com desejo de controle.</li>
      <li><strong>Alta Conformidade (C)</strong>: criterioso, analítico, detalhista, com foco em qualidade e precisão.</li>
    </ul>', '<ul>
      <li>Ambientes de alta exigência técnica e cobrança por resultados.</li>
      <li>Gestão de projetos complexos com muitos riscos e variáveis.</li>
      <li>Setores que exigem precisão e tomada de decisão sob pressão.</li>
      <li>Cargos de liderança, auditoria, engenharia ou estratégia.</li>
    </ul>');
INSERT INTO disc.factor_combination_description
(factor_combination_id, factor_combination, title, description, "characteristics", strengths, challenges, combination_details, stands_out)
VALUES(7, 'D=C', 'EXIGÊNCIA', 'Costumam ser exigentes e focados em boas entregas. Querem solucionar problemas e desafios, mas muito preocupados em fazer da forma mais adequada possível. Com isso, apresentam um perfil um tanto ambíguo e, até mesmo, indeciso quando precisam algo.', '<ul>
      <li><strong>Exigente e racional</strong>: busca resultados com base em lógica, regras e excelência.</li>
      <li><strong>Líder técnico e disciplinado</strong>: orienta-se por metas e padrões elevados.</li>
      <li><strong>Controlador e reservado</strong>: gosta de processos bem definidos e dificilmente expressa emoções.</li>
      <li><strong>Objetivo e estratégico</strong>: toma decisões firmes baseadas em dados, não em emoções.</li>
    </ul>', '<ul>
      <li>Alto nível de exigência com foco em resultados sustentáveis.</li>
      <li>Precisão na execução e planejamento rigoroso.</li>
      <li>Resiliência e controle emocional em ambientes de pressão.</li>
      <li>Decisões baseadas em fatos, lógica e estratégia.</li>
    </ul>', '<ul>
      <li>Pode parecer frio ou inflexível em situações interpessoais.</li>
      <li>Dificuldade em aceitar mudanças bruscas ou improvisações.</li>
      <li>Tende a ter pouca paciência com erros ou informalidades.</li>
      <li>Corre o risco de priorizar tarefas em detrimento das pessoas.</li>
    </ul>', '<ul>
      <li><strong>Alta Dominância (D)</strong>: orientado a resultados, assertivo, decidido, competitivo.</li>
      <li><strong>Alta Conformidade (C)</strong>: criterioso, analítico, focado em precisão, qualidade e regras.</li>
    </ul>', '<ul>
      <li>Gestão técnica ou de operações com alto grau de complexidade.</li>
      <li>Ambientes que exigem resultados mensuráveis e precisão rigorosa.</li>
      <li>Engenharia, auditoria, controladoria, logística estratégica.</li>
      <li>Funções que combinam autoridade com controle e normas.</li>
    </ul>');
INSERT INTO disc.factor_combination_description
(factor_combination_id, factor_combination, title, description, "characteristics", strengths, challenges, combination_details, stands_out)
VALUES(11, 'Id', 'CONEXÃO', 'Geralmente são pessoas com grande habilidade social e facilidade para se comunicar com todo tipo de pessoa. Podem usar de sua persuasão mais para conseguir apoio emocional, do que para trabalhar em metas pessoais. Costumam ter foco em trasmitir ideias e projetos, bem como em treinar pessoas.', '<ul>
      <li><strong>Motivador e dinâmico</strong>: gosta de interagir, inspirar e agir com energia.</li>
      <li><strong>Influência com direção</strong>: sabe envolver pessoas e direcioná-las para resultados.</li>
      <li><strong>Espírito empreendedor</strong>: cria, propõe e lidera com otimismo e coragem.</li>
      <li><strong>Persuasivo e proativo</strong>: combina charme social com ação rápida.</li>
    </ul>', '<ul>
      <li>Excelente comunicação e habilidade de relacionamento.</li>
      <li>Boa capacidade de iniciar projetos e engajar pessoas.</li>
      <li>Postura confiante e entusiasta.</li>
      <li>Facilidade para trabalhar em equipe e influenciar decisões.</li>
    </ul>', '<ul>
      <li>Pode pecar pela impulsividade e falta de foco em detalhes.</li>
      <li>Tem tendência a minimizar riscos ou desconsiderar regras.</li>
      <li>Pode deixar tarefas inacabadas por priorizar o novo ou o social.</li>
      <li>Busca constante por estímulo pode gerar dispersão.</li>
    </ul>', '<ul>
      <li><strong>Alta Influência (I)</strong>: carismático, comunicativo, entusiasmado, voltado para pessoas.</li>
      <li><strong>Dominância moderada (d)</strong>: assertivo, confiante, com iniciativa e espírito de liderança.</li>
    </ul>', '<ul>
      <li>Ambientes que valorizam energia, ideias e relacionamento interpessoal.</li>
      <li>Vendas, marketing, mídias sociais, startups e liderança de projetos criativos.</li>
      <li>Funções que exigem entusiasmo e poder de persuasão.</li>
      <li>Times em fase de motivação ou transformação.</li>
    </ul>');
INSERT INTO disc.factor_combination_description
(factor_combination_id, factor_combination, title, description, "characteristics", strengths, challenges, combination_details, stands_out)
VALUES(12, 'ID', 'PERSUASÃO', 'Trata-se de um perfil com grande facilidade para liderar de maneira cordial, pois vendem bem suas ideias. São geramente extrovertidos e generalistas. têm plena consciência de sua habilidade para motivar pessoas a desempenharem funções ou atingirem objetivos.', '<ul>
      <li><strong>Extrovertido e assertivo</strong>: combina carisma com atitude proativa e foco em resultados.</li>
      <li><strong>Líder nato e inspirador</strong>: influencia pelo entusiasmo e pela confiança.</li>
      <li><strong>Alta energia e velocidade</strong>: pensa e age rápido, gosta de resolver e avançar.</li>
      <li><strong>Foco em impacto</strong>: quer fazer a diferença e deixar sua marca.</li>
    </ul>', '<ul>
      <li>Capacidade de engajar e liderar equipes com entusiasmo.</li>
      <li>Comunicação eficaz e inspiradora.</li>
      <li>Alta iniciativa e coragem para assumir riscos.</li>
      <li>Estilo de liderança motivador e voltado à ação.</li>
    </ul>', '<ul>
      <li>Pode ser impulsivo e tomar decisões sem aprofundamento.</li>
      <li>Dificuldade com rotinas, burocracias ou limitações.</li>
      <li>Corre o risco de impor suas ideias e parecer dominante demais.</li>
      <li>Pode se frustrar com lentidão ou resistência alheia.</li>
    </ul>', '<ul>
      <li><strong>Alta Influência (I)</strong>: comunicativo, entusiasmado, envolvente, motivador.</li>
      <li><strong>Alta Dominância (D)</strong>: decidido, competitivo, orientado a metas e ação.</li>
    </ul>', '<ul>
      <li>Ambientes que exigem liderança inspiradora e ação rápida.</li>
      <li>Vendas, empreendedorismo, eventos, marketing e inovação.</li>
      <li>Projetos com alta visibilidade e dinamismo.</li>
      <li>Equipes que precisam de direção clara e energia motivadora.</li>
    </ul>');
INSERT INTO disc.factor_combination_description
(factor_combination_id, factor_combination, title, description, "characteristics", strengths, challenges, combination_details, stands_out)
VALUES(14, 'Is', 'EXTROVERSÃO', 'Pessoas com este  perfil costumam falar de modo acelerado e, geralmente, com um tom de voz elevado. De forma espontânea, comunicam-se com vários tipos de pessoas, por isso, um de seus focos está em ampliar a sua rede de contatos.', '<ul>
      <li><strong>Comunicativo e acolhedor</strong>: cria vínculos com facilidade e transmite segurança nas interações.</li>
      <li><strong>Influência gentil</strong>: persuade de forma sutil, com empatia e apoio.</li>
      <li><strong>Busca harmonia</strong>: prefere ambientes agradáveis, onde possa colaborar e inspirar.</li>
      <li><strong>Leal e envolvente</strong>: valoriza as relações pessoais e o bem-estar do grupo.</li>
    </ul>', '<ul>
      <li>Alta capacidade de criar conexões humanas duradouras.</li>
      <li>Boa escuta ativa com atitude positiva.</li>
      <li>Inspira confiança e empatia nas equipes.</li>
      <li>Facilidade em ambientes colaborativos e estáveis.</li>
    </ul>', '<ul>
      <li>Pode evitar conflitos e decisões difíceis.</li>
      <li>Busca de aprovação pode atrasar ações importantes.</li>
      <li>Tende a priorizar relações em detrimento de resultados.</li>
      <li>Resistência a mudanças bruscas e ambientes de alta pressão.</li>
    </ul>', '<ul>
      <li><strong>Alta Influência (I)</strong>: extrovertido, comunicativo, entusiasta, voltado a pessoas.</li>
      <li><strong>Estabilidade moderada (s)</strong>: cooperativo, confiável, paciente e consistente.</li>
    </ul>', '<ul>
      <li>Ambientes que valorizam empatia, relacionamento e atendimento ao cliente.</li>
      <li>Funções ligadas a suporte, educação, RH, hospitalidade e relacionamento.</li>
      <li>Times que demandam estabilidade emocional e espírito de equipe.</li>
      <li>Culturas organizacionais baseadas em pessoas e colaboração.</li>
    </ul>');
INSERT INTO disc.factor_combination_description
(factor_combination_id, factor_combination, title, description, "characteristics", strengths, challenges, combination_details, stands_out)
VALUES(15, 'IS', 'SOCIABILIDADE', 'Geralmente são amigáveis e abertos, principalmente frente a grupos de amigos ou conhecidos. Sua principal fortaleza é a capacidade para fazer contatos, pois são muito sociáveis.e têm facilidade para se misturar a qualquer tipo de grupo. ', '<ul>
      <li><strong>Comunicador acolhedor</strong>: cria vínculos profundos e duradouros com empatia e entusiasmo.</li>
      <li><strong>Influência emocionalmente segura</strong>: combina entusiasmo com estabilidade emocional.</li>
      <li><strong>Engajado e colaborativo</strong>: gosta de trabalhar com pessoas, de forma harmônica e positiva.</li>
      <li><strong>Respeitado pela gentileza</strong>: sua influência vem do cuidado, não da imposição.</li>
    </ul>', '<ul>
      <li>Alto poder de engajamento com empatia e lealdade.</li>
      <li>Estabilidade emocional com excelente capacidade de escuta.</li>
      <li>Facilidade para integrar equipes e criar ambientes positivos.</li>
      <li>Boa adaptabilidade em contextos humanos e cooperativos.</li>
    </ul>', '<ul>
      <li>Evita confrontos e decisões difíceis para preservar relações.</li>
      <li>Pode resistir a mudanças ou se sentir inseguro com ambientes agitados.</li>
      <li>Tendência a procrastinar ações difíceis.</li>
      <li>Busca aprovação constante, o que pode afetar a assertividade.</li>
    </ul>', '<ul>
      <li><strong>Alta Influência (I)</strong>: carismático, comunicativo, entusiasta, voltado para pessoas.</li>
      <li><strong>Alta Estabilidade (S)</strong>: confiável, paciente, cooperativo e leal.</li>
    </ul>', '<ul>
      <li>Áreas de atendimento, suporte, educação, saúde e hospitalidade.</li>
      <li>Ambientes que valorizam empatia, paciência e cooperação.</li>
      <li>Times que exigem equilíbrio emocional e espírito de equipe.</li>
      <li>Organizações com foco em pessoas, inclusão e bem-estar.</li>
    </ul>');
INSERT INTO disc.factor_combination_description
(factor_combination_id, factor_combination, title, description, "characteristics", strengths, challenges, combination_details, stands_out)
VALUES(16, 'Ic', 'ENTUSIASMO', 'Costumam delegar funções que envolvam detalhes, pois não possuem muita habilidade para lidar com pormenores. São pessoas desinibidas, seguras de si, informais e focadas em expandir suas relações interpessoais.', '<ul>
      <li><strong>Comunicativo e cuidadoso</strong>: se expressa com empatia, mas com atenção ao contexto.</li>
      <li><strong>Influência equilibrada</strong>: sabe cativar e se conectar, respeitando normas e limites.</li>
      <li><strong>Busca aceitação com responsabilidade</strong>: quer agradar, mas com preocupação em “fazer o certo”.</li>
      <li><strong>Flexível com bom senso</strong>: adapta-se bem, desde que dentro de um padrão razoável.</li>
    </ul>', '<ul>
      <li>Facilidade de comunicação com preocupação ética e analítica.</li>
      <li>Boa imagem pessoal e socialmente responsável.</li>
      <li>Sabe equilibrar empatia e regras.</li>
      <li>Habilidade para atuar em ambientes que exigem tato e precisão.</li>
    </ul>', '<ul>
      <li>Tendência a evitar conflitos para manter boa imagem.</li>
      <li>Pode ser indeciso diante de regras rígidas ou expectativas sociais.</li>
      <li>Busca excessiva por aprovação pode comprometer sua autonomia.</li>
      <li>Pode demorar a se posicionar diante de situações complexas.</li>
    </ul>', '<ul><li><strong>Alta Influência (I)</strong>: sociável, entusiasta, voltado para pessoas e comunicação.</li>
      <li><strong>Conformidade moderada (c)</strong>: valoriza a precisão, ética, estrutura e qualidade, de forma secundária.</li>
    </ul>', '<ul>
      <li>Áreas como comunicação interna, marketing, atendimento, RH e suporte.</li>
      <li>Ambientes que valorizam a empatia com responsabilidade e organização.</li>
      <li>Funções que exigem interação com pessoas, mas com certo grau de controle.</li>
      <li>Organizações com cultura equilibrada entre pessoas e processos.</li>
    </ul>');
INSERT INTO disc.factor_combination_description
(factor_combination_id, factor_combination, title, description, "characteristics", strengths, challenges, combination_details, stands_out)
VALUES(17, 'IC', 'SUPORTE', 'A pessoa com este perfil geralmente é tranquila e paciente quando lida com pressão ou frente a situações complexas, o foco está em manter a paz. Não costuma enfrentar os problemas, prefere aguardar até que tudo se resolva naturalmente, o que nem sempre acontece.', '<ul>
  <li><strong>Alta Influência (I)</strong>: comunicativo, entusiasta, focado em pessoas e no ambiente.</li>
  <li><strong>Alta Conformidade (C)</strong>: criterioso, analítico, preocupado com padrões, qualidade e regras.</li>
  <li><strong>Sociáveis, mas cuidadosas</strong>: gostam de se relacionar, mas com atenção à ética, contexto e limites.</li>
  <li><strong>Mediadoras por natureza</strong>: conciliam a empatia com o respeito a processos e normas.</li>
  <li><strong>Flexíveis com responsabilidade</strong>: sabem adaptar a comunicação sem perder o senso de certo e errado.</li>
  <li><strong>Organizadas e relacionais</strong>: estruturam suas tarefas, mas sempre considerando o fator humano.</li>
</ul>', '<ul>
      <li>Excelente capacidade de comunicação com atenção a detalhes.</li>
      <li>Tendência a buscar harmonia entre pessoas e sistemas.</li>
      <li>Pensamento lógico com sensibilidade social.</li>
    </ul>', '<ul>
      <li>Pode demorar para tomar decisões por querer agradar e seguir padrões ao mesmo tempo.</li>
      <li>Sensível à crítica, principalmente quando se esforça para fazer o certo.</li>
      <li>Pode evitar conflitos, mesmo quando necessários.</li>
    </ul>', '<ul>
      <li><strong>Alta Influência (I)</strong>: comunicativo, entusiasta, focado em pessoas e no ambiente.</li>
  <li><strong>Alta Conformidade (C)</strong>: criterioso, analítico, preocupado com padrões, qualidade e regras.</li>
</ul>', '<ul>
      <li>Vendas consultivas</li>
      <li>Comunicação interna</li>
      <li>Relações públicas</li>
    </ul>');
INSERT INTO disc.factor_combination_description
(factor_combination_id, factor_combination, title, description, "characteristics", strengths, challenges, combination_details, stands_out)
VALUES(18, 'Sd', 'FOCO', 'Demonstra um perfil bastante atencioso. São grandes observadores e com capacidade para pensar, ouvir e acolher os demais. Suas principais forças são a habilidade para manter o foco e a concentração por um longo período de tempo, bem como a sua capacidade para aconselhar outras pessoas com base em suas experiências e vivências.', '<ul>
      <li><strong>Calmo, mas firme</strong>: mantém a tranquilidade, mas sabe impor limites quando necessário.</li>
      <li><strong>Liderança serena</strong>: conduz pessoas com equilíbrio, constância e exemplo.</li>
      <li><strong>Persistente e resiliente</strong>: não desiste facilmente e se adapta com paciência.</li>
      <li><strong>Confiável sob pressão</strong>: age com constância mesmo diante de desafios.</li>
    </ul>', '<ul>
      <li>Capacidade de liderar de forma discreta e constante.</li>
      <li>Alta tolerância ao estresse e bom senso em decisões.</li>
      <li>Combina empatia com objetividade suave.</li>
      <li>Trabalho consistente com foco em metas de longo prazo.</li>
    </ul>', '<ul>
      <li>Pode ser relutante em aceitar mudanças rápidas.</li>
      <li>Tende a evitar confrontos, mesmo quando necessários.</li>
      <li>Demora para reagir sob pressão extrema ou em ambientes muito agressivos.</li>
      <li>Corre o risco de se calar diante de injustiças ou falhas alheias.</li>
    </ul>', '<ul>
      <li><strong>Alta Estabilidade (S)</strong>: calmo, paciente, confiável, consistente e cooperativo.</li>
      <li><strong>Dominância moderada (d)</strong>: assertivo, determinado e focado em alcançar objetivos, mas sem pressa.</li>
    </ul>', '<ul>
      <li>Ambientes que valorizam consistência, lealdade e foco.</li>
      <li>Funções que exigem paciência, atenção a processos e resultados sustentáveis.</li>
      <li>Áreas como operações, suporte técnico, gestão de processos e administração.</li>
      <li>Times que precisam de estabilidade e organização emocional.</li>
    </ul>');
INSERT INTO disc.factor_combination_description
(factor_combination_id, factor_combination, title, description, "characteristics", strengths, challenges, combination_details, stands_out)
VALUES(19, 'SD', 'PLANEJAMENTO', 'Trata-se de um perfil que não gosta de lidar com pressão, seja de superiores ou de tempo para entregar resultados. Tende a ter calma, mas com uma mente um tanto agitada. Gosta de ter tempo e liberdade para moldar as coisas ao seu redor de acordo com a velocidade de sua preferência. ', '<ul>
      <li><strong>Determinado e equilibrado</strong>: persegue objetivos com constância e firmeza.</li>
      <li><strong>Líder prático e paciente</strong>: conduz com estrutura, escuta e resiliência.</li>
      <li><strong>Respeitado pela consistência</strong>: inspira confiança e entrega resultados sólidos.</li>
      <li><strong>Estável, mas assertivo</strong>: lida bem com pressão sem perder o controle emocional.</li>
    </ul>', '<ul>
      <li>Capacidade de tomar decisões com equilíbrio e firmeza.</li>
      <li>Alto nível de disciplina e confiabilidade.</li>
      <li>Combina empatia com objetividade e foco.</li>
      <li>Liderança baseada em consistência, não imposição.</li>
    </ul>', '<ul>
      <li>Pode resistir a mudanças ou improvisos.</li>
      <li>Corre o risco de ser excessivamente inflexível ou obstinado.</li>
      <li>Tende a guardar conflitos internos em vez de externá-los.</li>
      <li>Pode se tornar controlador ao buscar estabilidade e domínio.</li>
    </ul>', '<ul>
      <li><strong>Alta Estabilidade (S)</strong>: paciente, constante, confiável e voltado à cooperação.</li>
      <li><strong>Alta Dominância (D)</strong>: decidido, firme, voltado a metas e liderança.</li>
    </ul>', '<ul>
      <li>Gestão de times e processos com foco em resultados sustentáveis.</li>
      <li>Ambientes que valorizam firmeza com empatia.</li>
      <li>Operações, projetos estruturais, áreas administrativas e industriais.</li>
      <li>Funções que exigem equilíbrio emocional e liderança sólida.</li>
    </ul>');
INSERT INTO disc.factor_combination_description
(factor_combination_id, factor_combination, title, description, "characteristics", strengths, challenges, combination_details, stands_out)
VALUES(20, 'Si', 'FOCO', 'Demonstra um perfil bastante atencioso. São grandes observadores e com capacidade para pensar, ouvir e acolher os demais. Suas principais forças são a habilidade para manter o foco e a concentração por um longo período de tempo, bem como a sua capacidade para aconselhar outras pessoas com base em suas experiências e vivências. ', '<ul>
      <li><strong>Gentil e cooperativo</strong>: busca relacionamentos harmônicos e ambientes estáveis.</li>
      <li><strong>Amigável e confiável</strong>: transmite segurança e empatia no contato com os outros.</li>
      <li><strong>Bom ouvinte</strong>: escuta com atenção e valoriza o bem-estar coletivo.</li>
      <li><strong>Prefere influenciar de forma sutil</strong>: atua com gentileza ao invés de imposição.</li>
    </ul>', '<ul>
      <li>Cria vínculos sólidos com base na confiança e empatia.</li>
      <li>Trabalha bem em equipe e promove colaboração.</li>
      <li>Constância e dedicação no cumprimento de tarefas.</li>
      <li>Capacidade de acalmar conflitos com postura serena.</li>
    </ul>', '<ul>
      <li>Pode evitar confrontos importantes para manter a paz.</li>
      <li>Tende a ser influenciado por opiniões externas.</li>
      <li>Resistência a mudanças ou improvisos.</li>
      <li>Corre o risco de se anular para agradar aos outros.</li>
    </ul>', '<ul>
      <li><strong>Alta Estabilidade (S)</strong>: calmo, confiável, paciente e constante.</li>
      <li><strong>Influência moderada (i)</strong>: sociável, simpático e agradável no convívio.</li>
    </ul>', '<ul>
      <li>Ambientes que valorizam cooperação, empatia e estabilidade.</li>
      <li>Áreas como suporte ao cliente, educação, saúde e gestão de pessoas.</li>
      <li>Funções que exigem relacionamentos duradouros e confiabilidade.</li>
      <li>Equipes que precisam de apoio emocional e harmonia no dia a dia.</li>
    </ul>');
INSERT INTO disc.factor_combination_description
(factor_combination_id, factor_combination, title, description, "characteristics", strengths, challenges, combination_details, stands_out)
VALUES(21, 'SI', 'RELACIONAMENTO INTERPESSOAL', 'Trata-se de um perfil com habilidade de comunicação e sociabilidade. Trabalha muito bem em equipe, sabe apoiar seus colegas de trabalho e demonstra facilidade para ouvir, antes de falar. Seu foco está mais em pessoas do que em tarefas, e pode precisar de incentivos para melhorar a sua concentração.', '<ul>
      <li><strong>Comunicador afetuoso</strong>: sabe ouvir e acolher, mantendo sempre o bom relacionamento.</li>
      <li><strong>Trabalha com equilíbrio</strong>: combina entusiasmo com estabilidade emocional.</li>
      <li><strong>Valoriza a harmonia</strong>: busca relações saudáveis e ambientes tranquilos.</li>
      <li><strong>Inspira pela empatia</strong>: conquista pelo afeto e pela atenção genuína.</li>
    </ul>', '<ul>
      <li>Alta habilidade interpessoal com foco em colaboração.</li>
      <li>Empatia, paciência e atenção às necessidades do outro.</li>
      <li>Comprometimento com o grupo e com o bem-estar coletivo.</li>
      <li>Capacidade de manter a paz e o equilíbrio em qualquer equipe.</li>
    </ul>', '<ul>
      <li>Tendência a evitar conflitos ou decisões impopulares.</li>
      <li>Busca excessiva por aprovação pode impactar sua assertividade.</li>
      <li>Pode resistir a mudanças que ameacem a estabilidade.</li>
      <li>Dificuldade em impor limites ou dizer “não”.</li>
    </ul>', '<ul>
      <li><strong>Alta Estabilidade (S)</strong>: constante, leal, paciente, voltado à cooperação.</li>
      <li><strong>Alta Influência (I)</strong>: comunicativo, entusiasta, amigável, voltado a pessoas.</li>
    </ul>', '<ul>
      <li>Ambientes humanos e colaborativos, que valorizam a convivência.</li>
      <li>Funções em suporte, educação, saúde, assistência social e RH.</li>
      <li>Equipes que precisam de acolhimento, empatia e escuta ativa.</li>
      <li>Organizações com foco em cultura inclusiva e ambientes saudáveis.</li>
    </ul>');
INSERT INTO disc.factor_combination_description
(factor_combination_id, factor_combination, title, description, "characteristics", strengths, challenges, combination_details, stands_out)
VALUES(22, 'Sc', 'CRIATIVIDADE', 'Geralmente são pessoas com uma boa capacidade criativa, pois conseguem pensar de forma abstrata e tendem a sair da "caixinha" para solucionar problemas. Conseguem ser persistentes na busca por soluções, porém não demonstram tanto apego a padrões, o que facilita na hora de pensar diferente dos demais.', '<ul>
      <li><strong>Tranquilo e responsável</strong>: cumpre suas tarefas com regularidade e cuidado.</li>
      <li><strong>Previsível e estruturado</strong>: gosta de rotina, regras claras e ambientes sem surpresas.</li>
      <li><strong>Atuação discreta e confiável</strong>: evita conflito e se comunica de forma reservada.</li>
      <li><strong>Valoriza segurança e estabilidade</strong>: prefere ambientes que ofereçam constância e organização.</li>
    </ul>', '<ul>
      <li>Confiabilidade e comprometimento com o que foi combinado.</li>
      <li>Disciplina e foco em processos e qualidade.</li>
      <li>Postura calma, paciente e colaborativa.</li>
      <li>Boa integração em equipes que exigem consistência e atenção aos detalhes.</li>
    </ul>', '<ul>
      <li>Dificuldade em lidar com mudanças repentinas.</li>
      <li>Pode ser resistente a improvisações ou ambientes muito dinâmicos.</li>
      <li>Tendência à passividade ou omissão em conflitos.</li>
      <li>Pode demorar a se adaptar a novos métodos e tecnologias.</li>
    </ul>', '<ul>
      <li><strong>Alta Estabilidade (S)</strong>: constante, paciente, confiável, colaborativo.</li>
      <li><strong>Conformidade moderada (c)</strong>: organizado, respeita regras, valoriza a precisão.</li>
    </ul>', '<ul>
      <li>Áreas que exigem constância, responsabilidade e organização.</li>
      <li>Administração, finanças, processos operacionais e atendimento estruturado.</li>
      <li>Funções com procedimentos bem definidos e foco em qualidade.</li>
      <li>Equipes que valorizam disciplina e confiança no trabalho em equipe.</li>
    </ul>');
INSERT INTO disc.factor_combination_description
(factor_combination_id, factor_combination, title, description, "characteristics", strengths, challenges, combination_details, stands_out)
VALUES(23, 'SC', 'PROCEDIMENTOS', 'Costumam atuar com calma e dificilmente se abalam frente a situações complexas. São muito bons para lidar com procedimentos estruturados e seguir normas pre-estabelecidas. Trabalham muito bem em funções que necessitem de organização, planejamento e especialização.', '<ul>
      <li><strong>Preciso e constante</strong>: trabalha com cuidado, atenção e regularidade.</li>
      <li><strong>Prefere ambientes seguros e estruturados</strong>: atua melhor com rotinas claras e previsibilidade.</li>
      <li><strong>Discreto e metódico</strong>: evita chamar atenção e prefere seguir regras do que improvisar.</li>
      <li><strong>Valoriza processos bem definidos</strong>: busca estabilidade com base em estrutura e lógica.</li>
    </ul>', '<ul>
      <li>Excelente executor de tarefas com foco em qualidade.</li>
      <li>Altamente confiável, disciplinado e coerente.</li>
      <li>Boa memória, atenção a detalhes e organização.</li>
      <li>Cria ambientes de confiança, consistência e precisão.</li>
    </ul>', '<ul>
      <li>Pode resistir a mudanças ou inovação se não forem bem justificadas.</li>
      <li>Dificuldade em lidar com pressão ou ambientes caóticos.</li>
      <li>Pode ser excessivamente crítico consigo e com os outros.</li>
      <li>Tende a evitar exposição ou decisões rápidas.</li>
    </ul>', '<ul>
      <li><strong>Alta Estabilidade (S)</strong>: paciente, calmo, leal, confiável e cooperativo.</li>
      <li><strong>Alta Conformidade (C)</strong>: detalhista, organizado, analítico e rigoroso com padrões.</li>
    </ul>', '<ul>
      <li>Ambientes com rotina, regras claras e padrões de excelência.</li>
      <li>Áreas como qualidade, processos, compliance, auditoria e administrativo.</li>
      <li>Funções que exigem paciência, atenção a detalhes e confiabilidade.</li>
      <li>Equipes que demandam estrutura, previsibilidade e precisão técnica.</li>
    </ul>');
INSERT INTO disc.factor_combination_description
(factor_combination_id, factor_combination, title, description, "characteristics", strengths, challenges, combination_details, stands_out)
VALUES(24, 'Cd', 'ANÁLISE', 'São pessoas discretas e de fala tranquila. Costumam ser  conservadoras em relação ao formato de trabalho, pois não gostam de mudanças bruscas, precisam de tempo para analisar o todo. Atuam sempre em busca de perfeição e qualidade. Tendem a demonstrar preocupação frente a situações complexas ou nem tão complexas assim.', '<ul>
      <li><strong>Exigente e metódico</strong>: busca excelência com foco em regras e resultados.</li>
      <li><strong>Tomador de decisão lógico</strong>: avalia os riscos e age com base em dados.</li>
      <li><strong>Reservado, mas firme</strong>: evita exposição emocional e se comunica de forma direta.</li>
      <li><strong>Controlador técnico</strong>: gosta de manter o domínio sobre o que executa.</li>
    </ul>', '<ul>
      <li>Alto padrão de qualidade e senso de responsabilidade.</li>
      <li>Capacidade analítica com foco em resultados consistentes.</li>
      <li>Planejamento cuidadoso e execução precisa.</li>
      <li>Combina objetividade com lógica e disciplina.</li>
    </ul>', '<ul>
      <li>Pode ser excessivamente perfeccionista ou crítico.</li>
      <li>Dificuldade em delegar por querer controlar os detalhes.</li>
      <li>Pode parecer inflexível ou distante nas relações interpessoais.</li>
      <li>Resistência a decisões rápidas ou improvisadas.</li>
    </ul>', '<ul>
      <li><strong>Alta Conformidade (C)</strong>: analítico, preciso, meticuloso, focado em qualidade e regras.</li>
      <li><strong>Dominância moderada (d)</strong>: assertivo, direto, orientado a metas, mas com cautela.</li>
    </ul>', '<ul>
      <li>Ambientes que exigem controle, precisão e responsabilidade técnica.</li>
      <li>Funções como engenharia, auditoria, processos, TI e finanças.</li>
      <li>Empresas que valorizam excelência, conformidade e desempenho.</li>
      <li>Equipes que precisam de rigor técnico e execução confiável.</li>
    </ul>');
INSERT INTO disc.factor_combination_description
(factor_combination_id, factor_combination, title, description, "characteristics", strengths, challenges, combination_details, stands_out)
VALUES(25, 'CD', 'RIGOR', 'Geralmente atuam muito bem em funções ou cargos que envolvam padrões e ordem. Costumam ser rigorosos, sempre em busca de melhorias e qualidade, expandindo isso para os que estão ao seu redor. Querem fazer tudo certo sempre. Tendem a ser comprometidos com as tarefas que lhe são designadas, mas presam por ter tudo sob seu controle..', '<ul>
      <li><strong>Racionais e objetivas</strong>: tomam decisões com base em dados e lógica.</li>
      <li><strong>Precisam de controle e clareza</strong>: gostam de estar no comando, mas com tudo bem estruturado.</li>
      <li><strong>Exigentes e detalhistas</strong>: cobram alto desempenho de si e dos outros.</li>
      <li><strong>Reservadas e firmes</strong>: priorizam eficiência sobre simpatia, podem parecer frias ou impacientes.</li>
</ul>', '<ul>
      <li>Alto padrão de qualidade com foco em metas.</li>
      <li>Capacidade de tomar decisões difíceis baseadas em fatos.</li>
      <li>Organização, disciplina e objetividade.</li>
      <li>Planejamento estratégico com execução rigorosa.</li>
    </ul>', '<ul>
      <li>Dificuldade em lidar com erros alheios ou imprevistos.</li>
      <li>Pode ser excessivamente crítico ou impaciente com lentidão.</li>
      <li>Tende a ser menos sensível ao lado emocional das situações.</li>
      <li>Risco de inflexibilidade ao seguir regras ou padrões.</li>
    </ul>', '<ul>
      <li><strong>Alta Conformidade (C)</strong>: analítico, orientado a regras, meticuloso, focado em qualidade e precisão.</li>
      <li><strong>Alta Dominância (D)</strong>: decidido, competitivo, orientado a resultados, direto na comunicação.</li>
</ul>', '<ul>
      <li>Engenharia</li>
      <li>Controladoria</li>
      <li>Auditoria</li>
      <li>Gestão de operações e qualidade</li>
      <li>Liderança de projetos complexos e de alta exigência</li>
    </ul>');
INSERT INTO disc.factor_combination_description
(factor_combination_id, factor_combination, title, description, "characteristics", strengths, challenges, combination_details, stands_out)
VALUES(26, 'Ci', 'PRECISÃO', 'Demonstram um perfil exigente, perfeccionista, sempre atento a detalhes. São pessoas muito analíticas e falam pouco ou o essencial, mas ao comunicar algo, tendem a se utilizar de pesquisas, livros, dados, munindo-se sempre de boas referências. Costumam ser mais fechados e pode ser difícil acessá-los, por isso, passam a impressão de um perfil distante.', '<ul>
      <li><strong>Cuidadoso e educado</strong>: busca excelência sem perder o tato nas relações.</li>
      <li><strong>Comunicador técnico</strong>: transmite informações com clareza, cuidado e respeito aos detalhes.</li>
      <li><strong>Observador e reservado</strong>: prefere entender bem antes de se expor ou opinar.</li>
      <li><strong>Alinha padrão e empatia</strong>: deseja fazer certo e ao mesmo tempo ser bem-visto.</li>
    </ul>', '<ul>
      <li>Boa comunicação com base em lógica e responsabilidade.</li>
      <li>Alto senso ético e respeito a normas e padrões.</li>
      <li>Foco em entregar qualidade com cordialidade.</li>
      <li>Equilíbrio entre seriedade técnica e simpatia.</li>
    </ul>', '<ul>
      <li>Pode evitar decisões difíceis por receio de desagradar.</li>
      <li>Excesso de cautela pode atrasar entregas.</li>
      <li>Tendência à autocobrança e perfeccionismo.</li>
      <li>Dificuldade em lidar com ambientes muito informais ou desorganizados.</li>
    </ul>', '<ul>
      <li><strong>Alta Conformidade (C)</strong>: disciplinado, analítico, preocupado com precisão e regras.</li>
      <li><strong>Influência moderada (i)</strong>: comunicativo, agradável, voltado à aceitação e harmonia social.</li>
    </ul>', '<ul>
      <li>Funções que exigem comunicação técnica, como compliance, qualidade e atendimento especializado.</li>
      <li>Ambientes que valorizam ética, precisão e relações educadas.</li>
      <li>Projetos que demandam clareza, organização e padronização.</li>
      <li>Times que precisam de equilíbrio entre normas e pessoas.</li>
    </ul>');
INSERT INTO disc.factor_combination_description
(factor_combination_id, factor_combination, title, description, "characteristics", strengths, challenges, combination_details, stands_out)
VALUES(27, 'CI', 'CONSULTORIA', 'São pessoas com grande habilidade para atuar como consultores, principalmente mais voltados para áreas técnicas, devido a sua capacidade para treinar pessoas, o seu perfil preciso e focado tanto em qualidade, quanto em relacionamentos. Sempre cuidadosos, colaborativos, trabalham muito bem em equipe. ', '<ul>
      <li><strong>Comunicador criterioso</strong>: se expressa bem, mas com base em lógica e cuidado técnico.</li>
      <li><strong>Atencioso e respeitoso</strong>: busca agradar sem ultrapassar limites éticos e normativos.</li>
      <li><strong>Diplomático</strong>: tende a intermediar situações com bom senso e responsabilidade.</li>
      <li><strong>Imagem profissional confiável</strong>: transmite seriedade e simpatia ao mesmo tempo.</li>
    </ul>
', '<ul>
      <li>Capacidade de comunicação com responsabilidade e clareza.</li>
      <li>Ético, analítico e socialmente inteligente.</li>
      <li>Versátil: atua bem com pessoas e com processos.</li>
      <li>Foco em qualidade com empatia e diplomacia.</li>
    </ul>', '<ul>
      <li>Tendência a indecisão quando há conflito entre regras e relacionamentos.</li>
      <li>Pode evitar confronto direto para manter boa imagem.</li>
      <li>Busca de perfeição pode gerar autocobrança excessiva.</li>
      <li>Dificuldade em improvisar fora de padrões definidos.</li>
    </ul>', '<ul>
      <li><strong>Alta Conformidade (C)</strong>: detalhista, analítico, focado em normas e padrões.</li>
      <li><strong>Alta Influência (I)</strong>: comunicativo, empático, voltado a pessoas e persuasão.</li>
    </ul>', '<ul>
      <li>Ambientes que valorizam comunicação ética e padrões elevados.</li>
      <li>Funções como marketing institucional, atendimento qualificado, compliance e RH.</li>
      <li>Projetos que exigem análise, organização e empatia.</li>
      <li>Equipes que combinam técnica com relacionamento interpessoal.</li>
    </ul>');
INSERT INTO disc.factor_combination_description
(factor_combination_id, factor_combination, title, description, "characteristics", strengths, challenges, combination_details, stands_out)
VALUES(28, 'Cs', 'CONSISTÊNCIA', 'Demonstram habilidade para atuar em cargos que exijam seguir regras, controles, riscos, pois são rigorosos em relação a aplicação do que foi planejado. São exigentes, e atuam com foco em atender a cronogramas e padrões de qualidade. Também demonstram agilidade para fazer várias coisas ao mesmo tempo, desde que estas já tenham os seus métodos e padrões bem estabelecidos.', '<ul>
      <li><strong>Profissional confiável e metódico</strong>: executa com calma, precisão e consistência.</li>
      <li><strong>Organizado e pacífico</strong>: busca qualidade em um ambiente tranquilo e estruturado.</li>
      <li><strong>Evita riscos</strong>: prefere processos seguros e decisões bem embasadas.</li>
      <li><strong>Relacionamento reservado, porém cordial</strong>: se relaciona bem, mas com discrição.</li>
    </ul>', '<ul>
      <li>Execução disciplinada e comprometida com qualidade.</li>
      <li>Alta confiabilidade e responsabilidade.</li>
      <li>Planejamento cuidadoso e atenção a detalhes.</li>
      <li>Habilidade para manter ordem e estabilidade em processos.</li>
    </ul>', '<ul>
      <li>Dificuldade com mudanças repentinas ou ambientes agitados.</li>
      <li>Resistência à improvisação ou ações fora do planejado.</li>
      <li>Tendência à rigidez ou apego excessivo às regras.</li>
      <li>Pode demorar a se posicionar ou tomar decisões rápidas.</li>
    </ul>', '<ul>
      <li><strong>Alta Conformidade (C)</strong>: técnico, cuidadoso, disciplinado e atento às regras.</li>
      <li><strong>Estabilidade moderada (s)</strong>: paciente, constante, confiável e cooperativo.</li>
    </ul>', '<ul>
      <li>Funções que exigem controle, precisão e paciência.</li>
      <li>Áreas como financeiro, engenharia, TI, jurídico e processos de qualidade.</li>
      <li>Ambientes com foco em estabilidade, confiabilidade e estrutura.</li>
      <li>Equipes que exigem constância, ética e atenção aos detalhes.</li>
    </ul>');
INSERT INTO disc.factor_combination_description
(factor_combination_id, factor_combination, title, description, "characteristics", strengths, challenges, combination_details, stands_out)
VALUES(29, 'CS', 'COMPLEXIDADE', 'Possuem facilidade para analisar e solucionar questões complexas. Precisam de tempo para mapear os prós e contras, mas tendem a fazer avaliações minuciosas. Demonstram habilidade para auxiliar na implantação de projetos críticos. Embora tenha um perfil questionador, o intuito não é discordar, mas encontrar o melhor formato para evitar erros e atingir objetivos. ', '<ul>
      <li><strong>Paciente e detalhista</strong>: realiza com precisão, consistência e cuidado.</li>
      <li><strong>Responsável e metódico</strong>: cumpre prazos e regras com firmeza e sem estresse.</li>
      <li><strong>Prefere ambientes previsíveis</strong>: gosta de trabalhar com rotina e segurança.</li>
      <li><strong>Evita exposição desnecessária</strong>: é mais reservado, prefere trabalhar nos bastidores.</li>
    </ul>', '<ul>
      <li>Confiabilidade elevada e postura comprometida.</li>
      <li>Precisão na execução com paciência e equilíbrio.</li>
      <li>Bom senso, lealdade e atenção às regras e processos.</li>
      <li>Trabalho técnico com postura ética e colaborativa.</li>
    </ul>', '<ul>
      <li>Resistência a mudanças e ambientes muito dinâmicos.</li>
      <li>Pode ser rígido com normas e pouco flexível.</li>
      <li>Tende a evitar riscos e decisões sob pressão.</li>
      <li>Pode se sentir desconfortável com liderança ou exposição pública.</li>
    </ul>', '<ul>
      <li><strong>Alta Conformidade (C)</strong>: meticuloso, disciplinado, técnico e voltado à qualidade.</li>
      <li><strong>Alta Estabilidade (S)</strong>: confiável, calmo, constante e cooperativo.</li>
    </ul>', '<ul>
      <li>Funções que exigem controle, qualidade e previsibilidade.</li>
      <li>Áreas técnicas, de controle, compliance, engenharia ou financeiro.</li>
      <li>Ambientes que valorizam respeito às regras, paciência e responsabilidade.</li>
      <li>Equipes que precisam de estrutura, rigor e suporte confiável.</li>
    </ul>');

-- states

INSERT INTO disc.state
(state_id, "name", ibge_id)
VALUES(1, 'Rondônia', 11);
INSERT INTO disc.state
(state_id, "name", ibge_id)
VALUES(2, 'Acre', 12);
INSERT INTO disc.state
(state_id, "name", ibge_id)
VALUES(3, 'Amazonas', 13);
INSERT INTO disc.state
(state_id, "name", ibge_id)
VALUES(4, 'Roraima', 14);
INSERT INTO disc.state
(state_id, "name", ibge_id)
VALUES(5, 'Pará', 15);
INSERT INTO disc.state
(state_id, "name", ibge_id)
VALUES(6, 'Amapá', 16);
INSERT INTO disc.state
(state_id, "name", ibge_id)
VALUES(7, 'Tocantins', 17);
INSERT INTO disc.state
(state_id, "name", ibge_id)
VALUES(8, 'Maranhão', 21);
INSERT INTO disc.state
(state_id, "name", ibge_id)
VALUES(9, 'Piauí', 22);
INSERT INTO disc.state
(state_id, "name", ibge_id)
VALUES(10, 'Ceará', 23);
INSERT INTO disc.state
(state_id, "name", ibge_id)
VALUES(11, 'Rio Grande do Norte', 24);
INSERT INTO disc.state
(state_id, "name", ibge_id)
VALUES(12, 'Paraíba', 25);
INSERT INTO disc.state
(state_id, "name", ibge_id)
VALUES(13, 'Pernambuco', 26);
INSERT INTO disc.state
(state_id, "name", ibge_id)
VALUES(14, 'Alagoas', 27);
INSERT INTO disc.state
(state_id, "name", ibge_id)
VALUES(15, 'Sergipe', 28);
INSERT INTO disc.state
(state_id, "name", ibge_id)
VALUES(16, 'Bahia', 29);
INSERT INTO disc.state
(state_id, "name", ibge_id)
VALUES(17, 'Minas Gerais', 31);
INSERT INTO disc.state
(state_id, "name", ibge_id)
VALUES(18, 'Espírito Santo', 32);
INSERT INTO disc.state
(state_id, "name", ibge_id)
VALUES(19, 'Rio de Janeiro', 33);
INSERT INTO disc.state
(state_id, "name", ibge_id)
VALUES(20, 'São Paulo', 35);
INSERT INTO disc.state
(state_id, "name", ibge_id)
VALUES(21, 'Paraná', 41);
INSERT INTO disc.state
(state_id, "name", ibge_id)
VALUES(22, 'Santa Catarina', 42);
INSERT INTO disc.state
(state_id, "name", ibge_id)
VALUES(23, 'Rio Grande do Sul', 43);
INSERT INTO disc.state
(state_id, "name", ibge_id)
VALUES(24, 'Mato Grosso do Sul', 50);
INSERT INTO disc.state
(state_id, "name", ibge_id)
VALUES(25, 'Mato Grosso', 51);
INSERT INTO disc.state
(state_id, "name", ibge_id)
VALUES(26, 'Goiás', 52);
INSERT INTO disc.state
(state_id, "name", ibge_id)
VALUES(27, 'Distrito Federal', 53);

--field-of-interest
INSERT INTO disc.field_of_interest
(field_of_interest_id, field)
VALUES(1, 'Negócios e Gestão');
INSERT INTO disc.field_of_interest
(field_of_interest_id, field)
VALUES(2, 'Tecnologia da Informação');
INSERT INTO disc.field_of_interest
(field_of_interest_id, field)
VALUES(3, 'Comunicação e Marketing');
INSERT INTO disc.field_of_interest
(field_of_interest_id, field)
VALUES(4, 'Saúde e Bem-estar');
INSERT INTO disc.field_of_interest
(field_of_interest_id, field)
VALUES(5, 'Direito e Justiça');
INSERT INTO disc.field_of_interest
(field_of_interest_id, field)
VALUES(6, 'Engenharia e Exatas');
INSERT INTO disc.field_of_interest
(field_of_interest_id, field)
VALUES(7, 'Educação e Pesquisa');
INSERT INTO disc.field_of_interest
(field_of_interest_id, field)
VALUES(8, 'Criatividade e Artes');
INSERT INTO disc.field_of_interest
(field_of_interest_id, field)
VALUES(9, 'Finanças e Economia');
INSERT INTO disc.field_of_interest
(field_of_interest_id, field)
VALUES(10, 'Ciências Humanas e Sociais');