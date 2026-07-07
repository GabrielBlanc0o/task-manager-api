# Menu

@Entity -> esta clase representa una tabla

@Id -> este campo es la llave primaria

@GeneratedValue(strategy = GenerationType.IDENTITY) -> el id se auto incremeta

@OneToMany(mappedBy = "autor") -> el lado uno yo tengo mucho pero la conexion real vive en el otro lado

@ManyToOne -> yo pertenezco a uno de esos , de muchos a uno

@JoinColumn(name = "autor\_id") -> aqui esta el nombre de mi columna de llave foranea
