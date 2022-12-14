package com.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.DAO.UsuariosDAO;
import com.TO.Usuarios;

@Service
public class UsuariosService implements IUsuariosService{

    @Autowired
    UsuariosDAO usuarioDao;

    @Override
    @Transactional
    public Usuarios guardar(Usuarios usuario) {
        return usuarioDao.save(usuario);
    }

    @Override
    @Transactional
    public void eliminar(int id_usuarios) {
        usuarioDao.deleteById(id_usuarios);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuarios> listarusuarios() {
        return (List<Usuarios>) usuarioDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuarios buscaUsuarios(int id_usuarios) {
        return usuarioDao.findById(id_usuarios).orElse(null);
    }
    
}
