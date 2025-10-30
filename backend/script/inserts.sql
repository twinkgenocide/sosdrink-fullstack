INSERT INTO `categoria_blog` VALUES
('Productos'),
('Regulación'),
('Salud Pública');

INSERT INTO `blog` VALUES
('Estamos emocionados de anunciar el lanzamiento de nuestro nuevo sabor \"Tropical Power\". Esta bebida combina lo mejor de la piña, mango y un toque de maracuyá, ideal para quienes buscan energía y frescura en cada sorbo. Nuestro equipo de desarrollo trabajó cuidadosamente para equilibrar sabor, energía y seguridad en el consumo.\n\nAdemás, se han implementado estrictos controles de calidad y etiquetado, garantizando que cada botella cumpla con las normas vigentes de salud pública y consumo responsable. Recomendamos disfrutarla con moderación y acompañada de hidratación adecuada.\n\nPróximamente habrá degustaciones y promociones especiales en tiendas seleccionadas, así como información educativa sobre hábitos seguros de consumo.','2025-09-15 00:00:00.000000','api/img/nuevoSaborEnergetico2025.jpg','Descubre \'Tropical Power\', la nueva bebida que combina energía y frescura frutal.','¡Lanzamos nuestro nuevo sabor de bebida energética + alcohol!',1),
('El Ministerio de Salud anunció nuevas **regulaciones de etiquetado para bebidas alcohólicas**. Todas las botellas deberán incluir advertencias sobre consumo responsable y riesgos para la salud.\n\n- Etiquetas visibles con contenido alcohólico y advertencias sanitarias.\n- Información obligatoria sobre consumo recomendado por día.\n- Entrada en vigor: 1 de octubre de 2025.\n\nEstas medidas buscan reducir el consumo excesivo y proteger la salud de la población.','2025-09-10 00:00:00.000000','api/img/leyEtiquetadoAlcohol2025.jpg','El gobierno establece advertencias obligatorias en envases de alcohol.','Nuevos requisitos de etiquetado para bebidas alcohólicas',2),
('Estamos orgullosos de presentar nuestro licor cítrico premium, elaborado con limón, maracuyá y un toque secreto de hierbas aromáticas. Ideal para preparar cócteles sofisticados o disfrutar solo con hielo.\n\nCada botella pasa por un riguroso control de calidad y sigue los estándares de etiquetado responsable. Su sabor equilibrado permite múltiples combinaciones en la mixología, haciendo de esta bebida un imprescindible en bares y hogares.\n\nDisponible en tiendas especializadas y con promociones de lanzamiento para quienes deseen probar esta novedad.','2025-04-18 00:00:00.000000','api/img/llegoLicorCitrico2025.jpg','Licor con notas de limón y maracuyá, perfecto para cócteles y mixología.','¡Llegó el nuevo licor cítrico de la línea premium!',1),
('La Secretaría de Salud lanzó una **campaña de consumo responsable** dirigida a jóvenes y adultos. El objetivo es informar sobre riesgos y fomentar decisiones conscientes.\n\n- Charlas y talleres en colegios y universidades.\n- Material educativo sobre efectos del alcohol y tabaco.\n- Plataforma online con recursos interactivos para la comunidad.\n\nLa campaña estará activa durante todo el segundo semestre de 2025.','2025-07-18 00:00:00.000000','api/img/campanaConsumoResponsable2025.jpg','Iniciativa nacional promueve hábitos seguros y conscientes.','Campaña de consumo responsable de alcohol y tabaco',3),
('El gobierno implementará un **aumento en impuestos al tabaco** para desincentivar su consumo y financiar programas de prevención y tratamiento de enfermedades relacionadas.\n\n- Incremento de 15% en cigarrillos y tabaco de liar.\n- Fondos destinados a campañas educativas y clínicas de cesación.\n- Medida entra en vigencia el 1 de junio de 2025.\n\nSe espera una reducción progresiva del consumo especialmente entre jóvenes.','2025-05-12 00:00:00.000000','api/img/impuestoTabaco2025.jpg','Nuevo gravamen busca reducir consumo y financiar programas de salud.','Aumento de impuestos a productos de tabaco',2),
('El Ministerio de Salud anunció **restricciones estrictas para la publicidad de bebidas alcohólicas**, incluyendo redes sociales y televisión.\n\n- Prohibición de anuncios dirigidos a menores de 18 años.\n- Límites en horarios de transmisión y formatos digitales.\n- Multas para empresas que incumplan las normas.\n\nEstas medidas entrarán en vigor a partir de abril de 2025.','2025-03-05 00:00:00.000000','api/img/restriccionesPublicidadAlcohol2025.jpg','Limitaciones en medios y redes sociales buscan proteger a menores.','Nuevas restricciones a la publicidad de alcohol',2),
('La Dirección de Salud emitió un **informe sobre los riesgos del consumo de tabaco** destacando la relación con enfermedades respiratorias y cardiovasculares.\n\n- Se recomiendan programas de cesación para fumadores activos.\n- Importancia de evitar el tabaquismo pasivo, especialmente en niños.\n- Difusión de información preventiva a través de medios y escuelas.\n\nEl objetivo es concientizar sobre los daños y promover hábitos saludables.','2025-02-15 00:00:00.000000','api/img/alertaSaludTabaco2025.jpg','Informe sobre riesgos del consumo de tabaco y enfermedades asociadas.','Alerta sanitaria: efectos del tabaco en la salud',3);

INSERT INTO `tipo_producto` VALUES
('Alcohol'),
('Tabaco');

INSERT INTO `producto` VALUES
(10,'Pisco chileno suave y aromático, ideal para preparar piscolas.','api/img/pisco-mistral-35.jpg','Pisco Mistral 35° 750ml',8990,50,1),
(5,'Ron cubano añejado, con notas de caramelo y especias.','api/img/ron-havana-club.jpg','Ron Havana Club 7 Años 750ml',13990,30,1),
(20,'Cerveza lager chilena, fresca y equilibrada.','api/img/cerveza-artesanal.jpg','Cerveza Artesanal Kuntsmann 330ml',1990,120,1),
(8,'Vino chileno con cuerpo, aroma frutal y notas de roble.','api/img/vino-casillero.jpg','Vino Tinto Casillero del Diablo Cabernet Sauvignon 750ml',6490,40,1),
(50,'Clásico sabor Marlboro en su versión más suave.','api/img/cigarros-marlboro.jpg','Cigarrillos Marlboro Gold 20 unidades',5790,200,2),
(5,'Tequila mexicano añejo, con sabor suave y notas de agave.','api/img/tequila-jose-cuervo.jpg','Tequila José Cuervo Especial 700ml',11990,25,1),
(5,'Whisky escocés de malta y grano, 12 años de maduración.','api/img/whisky-jw-black.jpg','Whisky Johnnie Walker Black Label 750ml',24990,35,1),
(30,'Cerveza lager mexicana, refrescante y ligera.','api/img/cerveza-corona.jpg','Cerveza Corona 355ml',1590,150,1),
(5,'Ron cubano blanco, ideal para cocteles y mezclas.','api/img/ron-bacardi.jpg','Ron Bacardi Carta Blanca 750ml',12990,40,1),
(40,'Clásico sabor Marlboro fuerte y tradicional.','api/img/cigarros-marlboro-red.jpg','Cigarros Marlboro Red 20 unidades',5990,180,2),
(10,'Vino chileno fresco, con aromas cítricos y acidez equilibrada.','api/img/vino-sauvignon.jpg','Vino Blanco Concha y Toro Sauvignon Blanc 750ml',6990,50,1);

INSERT INTO `tipo_usuario` VALUES
('administrador'),
('cliente'),
('vendedor');

INSERT INTO `usuario` VALUES
('12.345.678-9','González Pérez','Admin123!','camila.gonzalez@gmail.com','Av. Providencia 1234, Depto. 12','Camila',1),
('15.432.109-7','Soto López','Vendedor789$','mariajose.soto@profesor.duoc.cl','Calle O’Higgins 890, Oficina 3','María José',3),
('18.765.432-1','Vargas Muñoz','Vendedor654&','valentina.vargas@duoc.cl','Av. Libertad 234, Local 2','Valentina',3),
('7.654.321-0','Torres Fernández','Cliente321@','jorge.torres@gmail.com','Pasaje Los Pinos 45, Depto. 5','Jorge',2),
('9.876.543-2','Rojas Martínez','Cliente456#','felipe.rojas@duoc.cl','Calle Quillota 567, Casa B','Felipe',2);

COMMIT;
