package ninja.cards;

import ninja.actions.NinjutsuAction;
import static ninja.Ninja.getResourcePath;import ninja.Ninja;import ninja.enums.CardColorEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import ninja.powers.BuildSandWallPower;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import static ninja.Ninja.getResourcePath;import ninja.Ninja;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class BuildSandWall extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("BuildSandWall");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/BuildSandWall.png";
    public static final String ID = "BuildSandWall";

    public BuildSandWall(){
        super (ID, NAME,Ninja.getResourcePath( IMG_PATH), 2, DESCRIPTION, CardType.POWER, CardColorEnum.SILVER, CardRarity.UNCOMMON, CardTarget.SELF);
        this.baseMagicNumber = 2;
        this.magicNumber = this.baseMagicNumber;
        this.exhaust = true;
        this.tags.add(CardTags.NINJUTSU);
    }

    public void use(AbstractPlayer p, AbstractMonster m ){
        CardCrawlGame.sound.play(ID);
        AbstractPower sandwall = p.getPower("SandWall");
        this.addToBot(new ApplyPowerAction(p,p,new BuildSandWallPower(p)));
        if(sandwall != null) {
            this.addToBot(new NinjutsuAction(p,new GainBlockAction(p, sandwall.amount), 1, ""));
        }
    }

    public void upgrade(){
        if(!this.upgraded){
            this.upgradeName();
            this.upgradeBaseCost(1);
        }
    }

    public AbstractCard makeCopy(){
        return new BuildSandWall();
    }
}
