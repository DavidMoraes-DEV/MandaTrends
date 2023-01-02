INSERT INTO tb_user (first_name, last_name, email, password, created_At) VALUES ('Admin', 'Developer', 'admin@dmdeveloper.com', '$2a$10$EtxNDJiOOVgT88lnBO6B5Oi83otMUyT75FTFuEAp5XG/5YGym.spK', NOW());

INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);

INSERT INTO tb_trend (title, description, main_subject, source, source_url) VALUES ('NRF 2020: conheça os top 5 assuntos do evento.', 'O maior evento sobre varejo do mundo mostrando as tendências, oportunidades e inovações para o setor.', 'NRF 2020', 'CMO ADOBE', 'https://www.acicampinas.com.br/blogs:acompanhe-os-principais-conteudos-do-primeiro-dia-da-nrf-2020');
INSERT INTO tb_trend (title, description, main_subject, source, source_url) VALUES ('Motorola RAZR 2019 começa a receber o android 11', 'Modelo lançado em 2019 com Android 9 recebe a segunda atualização de versão nos Estados Unidos.', 'RAZR 2019', 'Mundo Conectado', 'https://mundoconectado.com.br/noticias/v/19954/motorola-razr-2019-comeca-a-receber-o-android-11');
INSERT INTO tb_trend (title, description, main_subject, source, source_url) VALUES ('Petição para colocar Kobe Bryant no logo da NBA.', 'desc', 'Kobe Bryant', 'B9', 'https://www.b9.com.br/120495/peticao-para-inserir-kobe-bryant-no-logo-da-nba-conta-com-2-milhoes-de-assinaturas-e-apoio-de-jogadores/');
INSERT INTO tb_trend (title, description, main_subject, source, source_url) VALUES ('Garrafa do futuro gera corrida sustentável.', 'desc', 'Garrafa do Futuro', 'UOL', 'https://www.uol.com.br/ecoa/reportagens-especiais/agua-em-lata-e-em-papelao-nova-garrafa-do-futuro-gera-corrida-sustentavel/');
INSERT INTO tb_trend (title, description, main_subject, source, source_url) VALUES ('Água na caixa é nova tendência sustentável.', 'DESC', 'Água na Caixa', 'CONFREBRAS 2021', 'https://confrebras.org.br/agua-na-caixa-e-nova-tendencia-sustentavel/');
INSERT INTO tb_trend (title, description, main_subject, source, source_url) VALUES ('Empresa usa marketing para combater a fome.', 'DESC', 'Inovações no Marketing', 'Marketing Twitter', 'https://marketing.twitter.com/pt/success-stories/virgin-mobile-australia-feeds-the-hungry-with-a-hashtag');
INSERT INTO tb_trend (title, description, main_subject, source, source_url) VALUES ('WhatsApp terá função de pagamentos em 2020.', 'DESC', 'WhatsApp Payment', 'SHOWMETECH', 'https://www.showmetech.com.br/whatsapp-payments-no-brasil-em-2020');
INSERT INTO tb_trend (title, description, main_subject, source, source_url) VALUES ('WhatsApp lança serviço de pagamento na Índia.', 'DESC', 'WhatsApp Payment índia', 'Tech News', 'https://www.technews.co.mz/tecnologia/software/whatsapp-finalmente-comeca-a-lancar-servico-de-pagamento-na-india/');
INSERT INTO tb_trend (title, description, main_subject, source, source_url) VALUES ('Inovações em embalagens de comida.', 'DESC', 'Inovações de Design', 'gkpd', 'https://gkpb.com.br/11594/designer-cria-formas-cabelo');
INSERT INTO tb_trend (title, description, main_subject, source, source_url) VALUES ('Jovens preferem presentes Tecnológicos.', 'DESC', 'Jovens e a Tecnologia', 'BEM PARANÁ', 'https://www.bemparana.com.br/noticia/presentear-com-celular-e-tablet-cresce-entre-a-classe-c-d-e-e-');

INSERT INTO tb_trends_images (img_Url, trend_id) VALUES ('https://raw.githubusercontent.com/DavidMoraes-DEV/ProjectsAssets/main/mandatrends/content/nrf_2020.png', 1);
INSERT INTO tb_trends_images (img_Url, trend_id) VALUES ('https://raw.githubusercontent.com/DavidMoraes-DEV/ProjectsAssets/main/mandatrends/content/motorola_razr_2019.png', 2);
INSERT INTO tb_trends_images (img_Url, trend_id) VALUES ('https://raw.githubusercontent.com/DavidMoraes-DEV/ProjectsAssets/main/mandatrends/content/motorola_razr_2019_2.png', 2);
INSERT INTO tb_trends_images (img_Url, trend_id) VALUES ('https://raw.githubusercontent.com/DavidMoraes-DEV/ProjectsAssets/main/mandatrends/content/nba_kobe.png', 3);
INSERT INTO tb_trends_images (img_Url, trend_id) VALUES ('https://raw.githubusercontent.com/DavidMoraes-DEV/ProjectsAssets/main/mandatrends/content/agua_na_caixa.png', 4);
INSERT INTO tb_trends_images (img_Url, trend_id) VALUES ('https://raw.githubusercontent.com/DavidMoraes-DEV/ProjectsAssets/main/mandatrends/content/hope_in_box.png', 5);
INSERT INTO tb_trends_images (img_Url, trend_id) VALUES ('https://raw.githubusercontent.com/DavidMoraes-DEV/ProjectsAssets/main/mandatrends/content/virgin_mobile_mealforameal.png', 6);
INSERT INTO tb_trends_images (img_Url, trend_id) VALUES ('https://raw.githubusercontent.com/DavidMoraes-DEV/ProjectsAssets/main/mandatrends/content/whatsapp_1.png', 7);
INSERT INTO tb_trends_images (img_Url, trend_id) VALUES ('https://raw.githubusercontent.com/DavidMoraes-DEV/ProjectsAssets/main/mandatrends/content/whatsapp_2.png', 7);
INSERT INTO tb_trends_images (img_Url, trend_id) VALUES ('https://raw.githubusercontent.com/DavidMoraes-DEV/ProjectsAssets/main/mandatrends/content/whatsapp_3.png', 8);
INSERT INTO tb_trends_images (img_Url, trend_id) VALUES ('https://raw.githubusercontent.com/DavidMoraes-DEV/ProjectsAssets/main/mandatrends/content/macarrao_forma_de_cabelo.png', 9);
INSERT INTO tb_trends_images (img_Url, trend_id) VALUES ('https://raw.githubusercontent.com/DavidMoraes-DEV/ProjectsAssets/main/mandatrends/content/sonhando_presente.png', 10);
INSERT INTO tb_trends_images (img_Url, trend_id) VALUES ('https://raw.githubusercontent.com/DavidMoraes-DEV/ProjectsAssets/main/mandatrends/content/crianca_recebendo_presente.png', 10);
INSERT INTO tb_trends_images (img_Url, trend_id) VALUES ('https://raw.githubusercontent.com/DavidMoraes-DEV/ProjectsAssets/main/mandatrends/content/celular_caixa.png', 10);
INSERT INTO tb_trends_images (img_Url, trend_id) VALUES ('https://raw.githubusercontent.com/DavidMoraes-DEV/ProjectsAssets/main/mandatrends/content/grupo-jovens.png', 10);
