import { Component } from '@angular/core';
import {MatIconModule} from '@angular/material/icon';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faFacebookF, faGithub, faGoogle, faInstagram, faLinkedinIn, faTwitter } from '@fortawesome/free-brands-svg-icons';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.scss'],
  standalone: true,
  imports: [MatIconModule, FontAwesomeModule],
})
export class FooterComponent {

  readonly faFacebookF = faFacebookF;
  readonly faTwitter = faTwitter;
  readonly faGoogle = faGoogle;
  readonly faInstagram = faInstagram;
  readonly faLinkedinIn = faLinkedinIn;
  readonly faGithub = faGithub;


}
