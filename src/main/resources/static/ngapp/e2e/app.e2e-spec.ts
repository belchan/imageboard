import { BelchanPage } from './app.po';

describe('belchan App', () => {
  let page: BelchanPage;

  beforeEach(() => {
    page = new BelchanPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!');
  });
});
