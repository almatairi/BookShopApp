package mk.finki.ukim.wp.lab.convertors;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Converter;
import mk.finki.ukim.wp.lab.model.AuthorFullName;

import javax.print.attribute.Attribute;

import static javax.swing.plaf.synth.Region.SEPARATOR;

@Converter
public class AuthorFullNameConverter implements AttributeConverter<AuthorFullName, String> {
    @Override
    public String convertToDatabaseColumn(AuthorFullName authorFullName) {
        if(authorFullName == null){
            return null;
        }

        StringBuilder sb = new StringBuilder();
        if (authorFullName.getSurname() != null && !authorFullName.getSurname().isEmpty()){
            sb.append(authorFullName.getSurname());
            sb.append(SEPARATOR);
        }

        if (authorFullName.getName() != null && !authorFullName.getName().isEmpty()){
            sb.append(authorFullName.getName());
        }
        return sb.toString();
    }

    @Override
    public AuthorFullName convertToEntityAttribute(String s) {
        if(s == null || s.isEmpty()){
            return null;
        }

        String[] pieces = s.split(String.valueOf(SEPARATOR));

        if(pieces == null || pieces.length ==0){
            return null;
        }

        AuthorFullName authorFullName = new AuthorFullName();
        String firstPiece = !pieces[0].isEmpty() ? pieces[0] : null;
        if(s.contains((CharSequence) SEPARATOR)){
            authorFullName.setSurname(firstPiece);

            if(pieces.length >= 2 && pieces[1] != null && !pieces[1].isEmpty()){
                authorFullName.setName(pieces[1]);
             }
            }else{
                authorFullName.setName(firstPiece);
        }
        return  authorFullName;
    }
}
