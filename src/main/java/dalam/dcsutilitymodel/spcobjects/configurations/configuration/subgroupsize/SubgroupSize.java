package dalam.dcsutilitymodel.spcobjects.configurations.configuration.subgroupsize;

import jakarta.xml.bind.annotation.XmlAttribute;

public class SubgroupSize {

    //SubgroupSize Attributes
    @XmlAttribute(name = "Piece")
    private String piece;

    @XmlAttribute(name = "WithinPiece")
    private String withinPiece;

    //Constructor
    public SubgroupSize(String piece, String withinPiece) {
        this.piece = piece;
        this.withinPiece = withinPiece;
    }

    public SubgroupSize() {}
}
